import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = new Node(null, null, in.nextInt());
        for (int i = 1; i < n; i++) {
            int val = in.nextInt();
            createTree(root, val);
        }
        preOrder(root);
        System.out.println();
        postOrder(root);
    }

    public static void preOrder(Node n) {
        if (n == null) return;
        System.out.print(n.val+" ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void postOrder(Node n) {
        if (n == null) return;
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.val+" ");
    }

    public static void createTree(Node n, int val) {
        if (val < n.val) {
            if (n.left != null) createTree(n.left, val);
            else n.left = new Node(null, null, val);
        } else {
            if (n.right != null) createTree(n.right, val);
            else n.right = new Node(null, null, val);
        }
    }
}

class Node {
    Node left;
    Node right;
    int val;

    public Node(Node left, Node right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
