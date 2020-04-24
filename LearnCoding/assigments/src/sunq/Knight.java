package sunq;

/**
 * @author nick chen
 */
public class Knight extends Thread {

    private int id;
    private Agenda agendaNew;
    private Agenda agendaComplete;
    private Hall hall;
    private Quest quest;

    public Knight(int id, Agenda agendaNew, Agenda agendaComplete, Hall hall) {
        this.id = id;
        this.agendaNew = agendaNew;
        this.agendaComplete = agendaComplete;
        this.hall = hall;
        this.quest = null;
    }

    private void mingle() {
        try {
            // Knights enter the Great Hall, discuss their adventures with one another
            int time = Params.getMinglingTime();
            sleep(time);
        } catch (InterruptedException e) {
            System.err.println("Knight - mingle: InterruptedException");
        }
    }

    private void sitDown() {
        System.out.format("Knight %d sits at the Round Table.\n", id);
        hall.incrementSeated();
    }

    private void standUp() {
        System.out.format("Knight %d stands from the Round Table.\n", id);
        hall.decrementSeated();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            // 在外执行任务 条件 有任务 并且 任务未完成
            if (null != quest && !quest.isCompleted()) {
                // 就去完成任务
                System.out.format("Knight %d sets of to complete Quest %d!\n", id, quest.getId());
                try {
                    sleep(Params.getQuestingTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("Knight %d completes Quest %d!\n", id, quest.getId());
                quest.setCompleted(true);

            } else {
                // 有任务 但是已完成，或者没有任务
                // 那么就回去
                System.out.format("Knight %d enters %s.\n", id, hall.getName());
                // 和别的 knight 进行交流
                mingle();
                mingle();
                sitDown();

                // 坐下，等待开会
                hall.waitForMeetingStart();

                // report back completed quest if has one and acquire new quest
                if (null != quest) {
                    System.out.format("Knight %d releases Quest %d!\n", id, quest.getId());
                    agendaComplete.addNew(quest);
                    quest = null;
                }
                quest = agendaNew.getQuest();
                System.out.format("Knight %d acquires Quest %d!\n", id, quest.getId());
                standUp();
                mingle();
                mingle();

                // 离开圆桌，依然等待会议结束，才能离开去完成任务
                hall.waitForMeetingEnd();
                System.out.format("Knight %d exits from %s.\n", id, hall.getName());
            }
        }
    }
}
