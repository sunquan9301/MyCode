package assignment3;

/**
 * produce quest in quest Queue
 */
public class Producer extends Thread {
    private Agenda agenda;

    public Producer(Agenda dataManager) {
        this.agenda = dataManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Quest quest = Quest.getNewQuest();
                agenda.addNewQuest(quest);
                Thread.sleep(Params.getProduceQuestTime());
            } catch (Exception e) {
                this.interrupt();
            }
        }
    }
}
