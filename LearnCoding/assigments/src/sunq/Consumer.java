package sunq;

/**
 * Consumes completed quests from an agenda.
 *
 * @author ngeard@unimelb.edu.au
 */

public class Consumer extends Thread {

    /**
     * the wait zone from which cargo ships depart
     */
    private Agenda agenda;

    /**
     * creates a new consumer for the given wait zone
     *
     * @param agendaComplete complete agenda
     */
    Consumer(Agenda agendaComplete) {
        this.agenda = agendaComplete;
    }

    /**
     * repeatedly collect waiting ships from the departure zone
     */
    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                // remove a vessel that is in the departure wait zone
                agenda.removeComplete();

                // let some time pass before the next departure
                sleep(Params.QUEST_REMOVAL_TIME);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}
