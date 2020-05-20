package ReEncodeK;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        MinPQ minPQ = new MinPQ(n);
        for (int i = 1; i <= n; i++)
            minPQ.insert(new Node(i, cin.nextLong()));
        int remain = calRemainNodes(n, k);
        preBuild(minPQ, remain);
        Node root = buildTree(minPQ, k);
        long[] result = new long[1];
        result[0] = 0;
        calLength(root, 0, result);
        System.out.print(result[0]);

    }


    public static void calLength(Node node, int deep, long[] result) {
        if (node == null) return;
        if (node.isLeaf()) {
            result[0] = result[0] + node.freq * deep;
            return;
        }
        for (int i = 0; i < node.childs.length; i++)
            calLength(node.childs[i], deep + 1, result);
    }

    public static int calRemainNodes(int n, int k) {
        int count = 0;
        while (true) {
            if (Math.pow(k, count) <= n && Math.pow(k, count + 1) > n) {
                break;
            }
            count++;
        }
        int remain = n - (int) Math.pow(k, count);
        while(remain>=k){
            remain = remain+1-k;
        }
        return remain+1;
    }

    public static void preBuild(MinPQ minPQ, int len) {
        if (len == 0) return;
        Node[] childs = new Node[len];
        int count = 0;
        long freq = 0l;
        for (int i = 0; i < len; i++) {
            Node node = minPQ.delMin();
            childs[count++] = node;
            freq += node.freq;
        }
        Node newNode = new Node(-1, freq);
        newNode.updateChilds(childs);
        minPQ.insert(newNode);
    }

    public static Node buildTree(MinPQ minPQ, int k) {
        while (minPQ.size() > 1) {
            int len = Math.min(minPQ.size(), k);
            Node[] childs = new Node[len];
            int count = 0;
            long freq = 0l;
            for (int i = 0; i < len; i++) {
                Node node = minPQ.delMin();
                childs[count++] = node;
                freq += node.freq;
            }
            Node newNode = new Node(-1, freq);
            newNode.updateChilds(childs);
            minPQ.insert(newNode);
        }
        return minPQ.delMin();
    }

    static class Node {
        int val;
        long freq;
        Node[] childs;

        public Node(int val, long freq) {
            this.val = val;
            this.freq = freq;
        }

        public boolean isLeaf() {
            return val > 0;
        }


        public void updateChilds(Node[] childs) {
            this.childs = childs;
        }
    }

    static class MinPQ {
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

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        private InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        private short nextShort() {
            return Short.parseShort(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private float nextFloat() {
            return Float.parseFloat(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
