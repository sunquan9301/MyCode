package assign200471302;

public class SceneNode {
    static int numScenes = 0;
    String title;
    String sceneDescription;
    int sceneId;
    SceneNode left;
    SceneNode middle;
    SceneNode right;

    public SceneNode(String title, String des) {
        numScenes++;
        this.sceneId = numScenes;
        this.title = title;
        this.sceneDescription = des;
    }

    public void addScene(SceneNode sceneNode) {
        if (left == null) left = sceneNode;
        else if (middle == null) middle = sceneNode;
        else if (right == null) right = sceneNode;
        else throw new FullSceneException();
    }

    public boolean isEnding() {
        return left == null && middle == null && right == null;
    }

    public void displayScene() {
        System.out.println(
                title + "\n" + sceneDescription + "\n\n" + getChildOptString());
    }


    public void displayFullScene() {
        System.out.println(
                "Scene ID #" + sceneId + "\n"
                        + "Title: " + title + "\n"
                        + "Scene: " + sceneDescription + "\n"
                        + "Leads to: " + getChildString());
    }

    private String getChildOptString() {
        if (isEnding()) return "";
        String result = "A) " + left.title + "\n";
        if (middle != null) result = result + "B) " + middle.title + "\n";
        if (right != null) result = result + "C) " + right.title + "\n";
        return result;
    }

    private String getChildString() {
        if (isEnding()) return "NONE";
        String result = "\'" + left.title + "\'" + "(#" + left.sceneId + ")";
        if (middle != null) result = result + ", \'" + middle.title + "\'" + "(#" + middle.sceneId + ")";
        if (right != null) result = result + ", \'" + right.title + "\'" + "(#" + right.sceneId + ")";
        return result;
    }

    @Override
    public String toString() {
        String result = title + "(#" + sceneId + ")\n";
        if (left != null) result = result + "  A)" + left.toString() + "\n";
        if (middle != null) result = result + "  B)" + middle.toString() + "\n";
        if (right != null) result = result + "  C)" + right.toString() + "\n";
        return result;
    }
}
