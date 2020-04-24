package assign200471302;

public class FullSceneException extends RuntimeException {
    public FullSceneException() {
        super("The current node does not have any empty child nodes");
    }

}
