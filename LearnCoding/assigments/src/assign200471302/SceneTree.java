package assign200471302;

public class SceneTree {

    protected SceneNode root;
    protected SceneNode cursor;

    public SceneTree(String rootTitle, String rootDes) {
        root = new SceneNode(rootTitle, rootDes);
        cursor = root;
    }

    public void moveCursorBackwards() {
        if (cursor == null || cursor == root) throw new NoSuchNodeException();
        SceneNode result = getParentOfRoot(root, cursor);
        if (result == null) throw new NoSuchNodeException();
        cursor = result;
        System.out.println("Successfully moved back to " + cursor.title + ".");
    }

    private SceneNode getParentOfRoot(SceneNode node, SceneNode targetNode) {
        if (node == null || targetNode == null) return null;
        if (node.left == targetNode || node.middle == targetNode || node.right == targetNode) return node;
        SceneNode result = getParentOfRoot(node.left, targetNode);
        if (result != null) return result;
        result = getParentOfRoot(node.middle, targetNode);
        if (result != null) return result;
        result = getParentOfRoot(node.right, targetNode);
        return result;
    }

    public void moveCursorForwards(String option) {
        if (option.equals("A")) {
            if (cursor.left == null) throw new NoSuchNodeException();
            else {
                cursor = cursor.left;
                System.out.println("Successfully moved to " + cursor.title + ".");
            }
        } else if (option.equals("B")) {
            if (cursor.middle == null) throw new NoSuchNodeException();
            else {
                cursor = cursor.middle;
                System.out.println("Successfully moved to " + cursor.title + ".");
            }
        } else if (option.equals("C")) {
            if (cursor.right == null) throw new NoSuchNodeException();
            else {
                cursor = cursor.right;
                System.out.println("Successfully moved to " + cursor.title + ".");
            }
        }
        throw new NoSuchNodeException();
    }

    public void addNewNode(String title, String sceneDescription) throws FullSceneException {
        SceneNode node = new SceneNode(title, sceneDescription);
        cursor.addScene(node);
    }

    public void removeScene(String option) {
        if (option.equals("A")) {
            if (cursor.left == null) throw new NoSuchNodeException();
            else {
                System.out.println(cursor.left.title + " removed.");
                cursor.left = null;
            }
        } else if (option.equals("B")) {
            if (cursor.middle == null) throw new NoSuchNodeException();
            else {
                System.out.println(cursor.middle.title + " removed.");
                cursor.middle = null;
            }
        } else if (option.equals("C")) {
            if (cursor.right == null) throw new NoSuchNodeException();
            else {
                System.out.println(cursor.right.title + " removed.");
                cursor.right = null;
            }
        }
        throw new NoSuchNodeException();
    }

    public void moveScene(int sceneIDToMoveTo) {
        SceneNode targetNode = getChildNodeWithId(cursor, sceneIDToMoveTo);
        if (targetNode == null) throw new NoSuchNodeException();
        if (targetNode.left == null && targetNode.middle == null && targetNode.right == null)
            throw new FullSceneException();
        cursor = targetNode;
        System.out.println("Successfully moved to " + cursor.title + ".");
    }

    private SceneNode getChildNodeWithId(SceneNode node, int targetId) {
        if (node == null) return null;
        if (node.sceneId == targetId) return node;
        SceneNode result = getChildNodeWithId(node.left, targetId);
        if (result != null) return result;
        result = getChildNodeWithId(node.middle, targetId);
        if (result != null) return result;
        result = getChildNodeWithId(node.right, targetId);
        return result;
    }

    public String getPathFromRoot() {
        String[] s = new String[SceneNode.numScenes + 1];
        getPathFromRoot(root, cursor, s, 0);
        String str = "";
        for (int i = 0; i < s.length; i++) {
            if(s!=null&&s.length>0) str = str + "," + s[i];
            else break;
        }
        return str.substring(1);
    }

    public static boolean getPathFromRoot(SceneNode root, SceneNode node, String[] paths, int size) {
        if (root == null || node == null) return false;

        paths[size] = root.title;
        size++;

        if (root.sceneId == node.sceneId) return true;

        if (root.left != null)
            if (getPathFromRoot(root.left, node, paths, size)) return true;

        if (root.middle != null)
            if (getPathFromRoot(root.middle, node, paths, size)) return true;
        if (root.right != null)
            if (getPathFromRoot(root.right, node, paths, size)) return true;

        //回溯
        paths[size] = "";
        size--;
        return false;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
