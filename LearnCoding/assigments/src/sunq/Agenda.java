package sunq;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nick chen
 */
public class Agenda {
    private String name;
    private Queue<Quest> questList;

    public Agenda(String name) {
        this.name = name;
        questList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public synchronized void removeComplete() {
        if (questList.isEmpty()) {
            return;
        }

        Quest quest = questList.poll();
        System.out.format("Quest %d removed from %s.\n", quest.getId(), this.getName());
        // Notify producer that
        // status has changed.
        notifyAll();
    }

    public synchronized void addNew(Quest quest) {
        // Wait until message has
        // been retrieved.
        while (questList.size() >= Params.NUM_KNIGHTS) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.format("Quest %d added to %s.\n", quest.getId(), this.getName());
        questList.add(quest);
        // Notify consumer that status
        // has changed.
        notifyAll();
    }

    public synchronized Quest getQuest() {
        while (questList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        Quest quest = questList.poll();
        notifyAll();
        return quest;
    }
}
