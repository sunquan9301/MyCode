package assign200471302;

public class NoSuchNodeException extends RuntimeException {
    public NoSuchNodeException() {
        super("the current node does not have a parent");
    }
}
