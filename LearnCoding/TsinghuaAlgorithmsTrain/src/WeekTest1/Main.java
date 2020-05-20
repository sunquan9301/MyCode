package WeekTest1;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader cin = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = cin.nextInt();
        ArrayQueue q = new ArrayQueue();
        int[] val = new int[n];
        int[] maxArr = new int[n];
        for (int i = 0; i < n; i++) val[i] = cin.nextInt();

        maxArr[val.length - 1] = val[val.length - 1];
        for (int i = val.length - 2; i >= 0; i--) {
            maxArr[i] = Math.max(maxArr[i + 1], val[i]);
        }
        for (int i = 0; i < n; i++) {
            if (q.isEmpty() || Math.max(q.peekHead(), q.peekTail()) < maxArr[i]) {
                q.insert(val[i]);
            } else {
                int result = q.peekHead() < q.peekTail() ? q.deTail() : q.deHead();
                out.print(result + " ");
                i--;
            }
        }
        while (!q.isEmpty()) {
            int result = q.peekHead() < q.peekTail() ? q.deTail() : q.deHead();
            out.print(result + " ");
        }
        out.close();
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

    static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
            pre = this;
            next = null;
        }
    }

    static class ArrayQueue {
        int head;
        int tail;
        int n;
        int[] key;

        public ArrayQueue() {
            key = new int[2000001];
            n = 0;
            head = 0;
            tail = 0;
        }

        public void insert(int val) {
            n++;
            key[tail++] = val;
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int peekTail() {
            return key[tail - 1];
        }

        public int peekHead() {
            return key[head];
        }

        public int deHead() {
            n--;
            return key[head++];
        }

        public int deTail() {
            n--;
            return key[--tail];
        }
    }
}


//class Queue {
//    Node head;
//    Node tail;
//    int n;
//
//    public Queue() {
//        head = new Node(-1);
//        tail = head;
//        n = 0;
//    }
//
//    public void insert(int val) {
//        Node node = new Node(val);
//        if (tail == head) {
//            tail = node;
//            head.next = tail;
//            tail.pre = head;
//        } else {
//            tail.next = node;
//            node.pre = tail;
//            tail = node;
//        }
//        n++;
//    }
//
//    public int size() {
//        return n;
//    }
//
//    public boolean isEmpty() {
//        return n == 0;
//    }
//
//    public int peekTail() {
//        return tail.val;
//    }
//
//    public int peekHead() {
//        return head.next.val;
//    }
//
//    public int deHead() {
//        if (isEmpty()) return -1;
//        int result = 0;
//        if (n == 1) {
//            Node node = head.next;
//            result = node.val;
//            head.next = null;
//            tail = head;
//            node = null;
//        } else {
//            Node node = head.next;
//            head.next = node.next;
//            head.next.pre = head;
//            result = node.val;
//            node = null;
//        }
//        n--;
//        return result;
//    }
//
//    public int deTail() {
//        if (isEmpty()) return -1;
//        Node node = tail;
//        tail = tail.pre;
//        tail.next = null;
//        int result = node.val;
//        node = null;
//        n--;
//        return result;
//
//    }
//}

