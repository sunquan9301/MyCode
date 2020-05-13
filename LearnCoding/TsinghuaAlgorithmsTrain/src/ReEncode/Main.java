package ReEncode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        //初始化
        MinPQ minPQ = new MinPQ(n);
        for (int i = 1; i <= n; i++) minPQ.insert(new Node(i, cin.nextLong(), null, null));
        Node root = buildTree(minPQ);
        System.out.println(calLength(root, 0));
    }

    public static long calLength(Node node, int deep) {
        if(node == null) return 0;
        if(node.isLeaf()) return node.freq*deep;
        return calLength(node.left,deep+1)+calLength(node.right,deep+1);
    }

    public static Node buildTree(MinPQ minPQ) {
        while (minPQ.size() > 1) {
            Node first = minPQ.delMin();
            Node second = minPQ.delMin();
            Node newNode = new Node(-1, first.freq + second.freq, first, second);
            minPQ.insert(newNode);
        }
        return minPQ.delMin();
    }


}

class MinPQ {
    int n;
    Node[] pq;

    public MinPQ(int initCapacity) {
        this.n = 0;
        this.pq = new Node[initCapacity + 1];
    }

    public void insert(Node node) {
        pq[++n] = node;
        swim(n);
    }

    public void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public int size() {
        return n;
    }

    public Node delMin() {
        Node min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return min;
    }

    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        Node temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean greater(int i, int j) {
        return pq[i].freq > pq[j].freq;
    }
}

class Node {
    int val;
    long freq;
    Node left;
    Node right;

    public Node(int val, long freq, Node left, Node right) {
        this.val = val;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return val > 0;
    }


}
