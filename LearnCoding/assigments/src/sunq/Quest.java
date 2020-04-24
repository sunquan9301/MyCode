package sunq;

/**
 * A quest, with a unique id, to be assigned to a knight for completion
 * 
 * @author ngeard@unimelb.edu.au
 *
 */

public class Quest {

    /**
     * the next ID to be allocated
     */
    private static int nextId = 1;
    /**
     * a flag indicating whether the quest has been completed
     */
    boolean completed;
    /**
     * a unique identifier for this quest
     */
    private int id;

    /**
     * create a new vessel with a given identifier
     * @param id id
     */
    private Quest(int id) {
        this.id = id;
        this.completed = false;
    }

    /**
     * get a new Quest instance with a unique identifier
     * @return quest
     */
    public static Quest getNewQuest() {
        return new Quest(nextId++);
    }

    public int getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * produce an identifying string for the quest
     * @return String
     */
    @Override
    public String toString() {
        return "Quest " + id;
    }
}