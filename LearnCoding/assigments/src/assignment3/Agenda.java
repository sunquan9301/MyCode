package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Agenda {
    //for knight, where are three state
    // 1. out greate hall
    // 2. stand in greate hall
    // 3. sitting down greate hall
    static int OUT_GREATE_HALL = 0x1001;
    static int STAND_IN_GREATE_HALL = 0x1002;
    static int SITTING_DOWN_GREATE_HALL = 0x1003;

    //knight with different state of quest
    //1. new quest : be acqured in the greate hall
    //2. no quest : inital state for all knight except knight 1
    //3. complete quest: when in this state
    static int NEW_QUEST = 0x2001;
    static int NO_QUEST = 0x2002;
    static int COMPLETE_QUEST = 0x2003;

    //the quest id for queue
    private int questId = 2;

    // a variable to deceide if king in hall
    //when king is in hall, all knight can't enter or leave greate hall
    private boolean kingInHall = false;

    //to deceide is king start meeting, there is a interval between king enter greate hall and start meeting
    //the condition that king can start meeting is that all knight without new quest have sitted down
    private boolean kingStartMeeting = false;

    // used to synchronize variable king In hall with different thread
    private Object kingInHallObj = new Object();

    //used to synchronize variable kingstartmeeting with different tread
    private Object startMeetingObj = new Object();

    //new quest Queue
    private ArrayList<Quest> newQuestQueue = new ArrayList<>();
    //complete quest queue
    private ArrayList<Quest> completeQuestQueue = new ArrayList<>();
    // a array to record the state of knights like {OUT_GREATE_HALL, NO_QUEST}
    private int[][] knightStates;

    public Agenda(Quest initQuest) {
        //init
        newQuestQueue.add(initQuest);
        this.knightStates = new int[Params.KNIGHT_COUNT][2];
        Arrays.fill(knightStates, new int[]{OUT_GREATE_HALL, NO_QUEST});
        knightStates[0] = new int[]{OUT_GREATE_HALL, NEW_QUEST};
    }

    //quest producer offer quest, synchronized with lock newQuestQueue
    public void addNewQuest(Quest quest) throws Exception {
        synchronized (newQuestQueue) {
            newQuestQueue.add(quest);
            newQuestQueue.notify();
            System.out.println(quest.toString() + " added to New Agenda.");
            questId++;
        }
    }

    //all knight acquire quest, synchronized with lock newQuestQueue
    public Quest acquireQuest(Knight knight) throws Exception {
        synchronized (startMeetingObj) {
            if (!kingStartMeeting) startMeetingObj.wait();
            synchronized (newQuestQueue) {
                //when newQuestQueue is empty knight will be blocked to wait
                if (newQuestQueue.isEmpty()) {
                    System.out.println("Quest is Empty");
                    newQuestQueue.wait();
                }
                for (int i = 0; i < newQuestQueue.size(); i++) {
                    if (!newQuestQueue.get(i).completed) {
                        System.out.println("Knight " + (knight.nameId + 1) + " acquires " + newQuestQueue.get(i).toString());
                        return newQuestQueue.get(i);
                    }
                }
                return null;
            }
        }
    }

    //after knight acquiring quest, they will starnd up. When all knight stand up the king can end meeting
    public void standUp(Knight knight) throws Exception {
        synchronized (knightStates) {
            knightStates[knight.nameId] = new int[]{STAND_IN_GREATE_HALL, NEW_QUEST};
            boolean canKingEnd = true;
            for (int i = 0; i < knightStates.length; i++) {
                if (knightStates[i][0] == SITTING_DOWN_GREATE_HALL) {
                    canKingEnd = false;
                    break;
                }
            }
            if (canKingEnd) knightStates.notify();
        }
    }

    //kning prepare to levae greate. WHen king is still in greate hall ,knight can't leave
    public void prepareLeaveGreateHall(Knight knight) throws Exception {
        synchronized (knightStates) {
            // to check if king can enter greate hall.
            //king can't enter greate hall until all knight with new quest leave greate hall
            knightStates[knight.nameId] = new int[]{OUT_GREATE_HALL, NEW_QUEST};
            boolean isHasKnightGreatHall = false;
            for (int i = 0; i < knightStates.length; i++) {
                if (knightStates[i][0] != OUT_GREATE_HALL) {
                    isHasKnightGreatHall = true;
                    break;
                }
            }
            if (isHasKnightGreatHall) {
                boolean canKingEnter = true;
                for (int i = 0; i < knightStates.length; i++) {
                    if (knightStates[i][0] == STAND_IN_GREATE_HALL && knightStates[i][1] == NEW_QUEST) {
                        canKingEnter = false;
                        break;
                    }
                }
                if (canKingEnter) knightStates.notify();
            }
        }
        synchronized (kingInHallObj) {
            if (kingInHall) {
                kingInHallObj.wait();
            }
            System.out.println("Knight " + (knight.nameId + 1) + " exits from Great Hall.");
        }
    }

    //knight complete quest synchronized by knightStates
    public void completeQuest(Knight knight) throws Exception {
        synchronized (knightStates) {
            knightStates[knight.nameId][1] = COMPLETE_QUEST;
        }
        synchronized (newQuestQueue) {
            knight.quest.completed = true;
        }
    }

    //knight prepare enter greate hall. if king is in greate hall, it will be blocked
    public void prepareEnderGreateHall(Knight knight) throws Exception {
        synchronized (kingInHallObj) {
            if (kingInHall) {
                kingInHallObj.wait();
            }
            System.out.println("Knight " + (knight.nameId + 1) + " enters Great Hall.");
            synchronized (knightStates) {
                knightStates[knight.nameId][0] = STAND_IN_GREATE_HALL;
            }
        }
    }

    //after knight enter greate hall, they will discuss adventure and then sitting down
    public void sittingDown(Knight knight) {
        synchronized (knightStates) {
            knightStates[knight.nameId][0] = SITTING_DOWN_GREATE_HALL;
            //to check if king can start meeting the condition if that all knight sit
            boolean canKingStartMeeting = true;
            for (int i = 0; i < knightStates.length; i++) {
                if (knightStates[i][0] == STAND_IN_GREATE_HALL) {
                    canKingStartMeeting = false;
                    break;
                }
            }
            if (canKingStartMeeting) knightStates.notify();
            System.out.println("Knight " + (knight.nameId + 1) + " sits at the Round Table.");
        }
    }

    //knight report quest.
    public void reportQuest(Knight knight) throws Exception {
        synchronized (startMeetingObj) {
            //the condition is that king start meeting, otherwish it is blocked.
            if (!kingStartMeeting) startMeetingObj.wait();
            System.out.println("Knight " + (knight.nameId + 1) + " releases " + knight.quest.toString() + "!");
        }
    }

    //king prepare enter greate hall.
    //before this action; the condition is that no knight with new quest in the greate hall
    public void kingArthurEnterGreatHall() throws Exception {
        synchronized (knightStates) {
            boolean isHasKnightGreatHall = false;
            for (int i = 0; i < knightStates.length; i++) {
                if (knightStates[i][0] != OUT_GREATE_HALL) {
                    isHasKnightGreatHall = true;
                    break;
                }
            }
            if (!isHasKnightGreatHall) {
                knightStates.wait();
            } else {
                boolean canEnter = true;
                for (int i = 0; i < knightStates.length; i++) {
                    if (knightStates[i][0] == STAND_IN_GREATE_HALL && knightStates[i][1] == NEW_QUEST) {
                        canEnter = false;
                    }
                }
                if (!canEnter) knightStates.wait();
            }
        }
        //king enter in hall and notify all knight
        synchronized (kingInHallObj) {
            System.out.println("King Arthur enters the Great Hall.");
            kingInHall = true;
            kingInHallObj.notify();
        }
    }

    //king start meeting
    public void startMeeting() throws Exception {
        synchronized (knightStates) {
            //check if all knight have sitted down
            boolean canStart = true;
            for (int i = 0; i < knightStates.length; i++) {
                if (knightStates[i][0] == STAND_IN_GREATE_HALL) {
                    canStart = false;
                    break;
                }
            }
            if (!canStart) knightStates.wait();
            //start meeting and notify all knight
            synchronized (startMeetingObj) {
                kingStartMeeting = true;
                System.out.println("Meeting begins!");
                startMeetingObj.notify();
            }
        }

    }

    //king end meeting and leave
    public void kingArthurEndMeetingAndLeave() throws Exception {
        synchronized (knightStates) {
            boolean canEnd = true;
            //check if all knight have stand up
            for (int i = 0; i < knightStates.length; i++) {
                if (knightStates[i][0] == SITTING_DOWN_GREATE_HALL) {
                    canEnd = false;
                    break;
                }
            }
            if (!canEnd) knightStates.wait();
        }
        synchronized (kingInHallObj) {
            kingInHall = false;
            System.out.println("Meeting ends!");
            System.out.println("King Arthur exits the Great Hall.");
            kingInHallObj.notify();
        }
    }

    public void removeComplete() {
        //the completed quest will be added in complete quest queue
        Quest completeQuest;
        synchronized (newQuestQueue) {
            Iterator<Quest> iterator = newQuestQueue.iterator();
            while (iterator.hasNext()) {
                Quest next = iterator.next();
                if (next.completed) {
                    iterator.remove();
                    completeQuestQueue.add(next);
                }
            }
        }
    }
}
