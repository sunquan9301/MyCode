package sunq;

import java.util.concurrent.CountDownLatch;

/**
 * @author nick chen
 */
public class Hall {
    private CountDownLatch start;
    private CountDownLatch end;
    private String name;
    private Agenda agendaNew;
    private Agenda agendaComplete;
    private volatile boolean isKingPresent;
    private volatile int numOfSeated;

    public Hall(String name, Agenda agendaNew, Agenda agendaComplete) {
        this.name = name;
        this.agendaNew = agendaNew;
        this.agendaComplete = agendaComplete;
        this.isKingPresent = false;
        this.numOfSeated = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isKingPresent() {
        return isKingPresent;
    }

    public void setKingPresent(boolean kingPresent) {
        isKingPresent = kingPresent;
    }

    public synchronized void incrementSeated() {
        ++numOfSeated;
    }

    public synchronized void decrementSeated() {
        --numOfSeated;
    }

    public synchronized void waitForMeetingStart() {
        while (numOfSeated != Params.NUM_KNIGHTS || !isKingPresent()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized void startMeeting() {
        while (numOfSeated != Params.NUM_KNIGHTS) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Meeting begins!");
        notifyAll();
    }

    public synchronized void waitForMeetingEnd() {
        while (numOfSeated != 0 || isKingPresent()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();
    }

    public synchronized void endMeeting() throws InterruptedException {
        while (numOfSeated != 0) {
            wait();
        }
        System.out.println("Meeting ends!");
        System.out.println("King Arthur exits the Great Hall.");
        setKingPresent(false);
        notifyAll();
    }
}
