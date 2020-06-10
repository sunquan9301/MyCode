package Rhizomys;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        int m = in.nextInt();
        Graph graph = new Graph(n);
        for (int i = 1; i <= m; i++) {
            graph.insertEdge(in.nextInt(), in.nextInt(), in.nextInt());
        }

        IndexMinPQ indexMinPQ = new IndexMinPQ(n);
        int[] distTo = new int[n + 1];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[1] = 0;
        indexMinPQ.insert(1, 0);
        while (!indexMinPQ.isEmpty()) {
            int u = indexMinPQ.delMin();
            for (Edge e : graph.adj[u]) {
                if (e.isSelfCircle) continue;
                int v = e.other(u);
                if (distTo[v] >= distTo[u] + e.w) {
                    distTo[v] = distTo[u] + e.w;
                    e.isUse = true;
                    if (indexMinPQ.contains(v)) indexMinPQ.changeKey(v, distTo[v]);
                    else indexMinPQ.insert(v, distTo[v]);
                }
            }
        }
        int[] mark = new int[n + 1];
        mark[1] = 1;
        ArrayDeque<QueueBean> queue = new ArrayDeque<QueueBean>();
        queue.addLast(new QueueBean(1, 0));
        while (!queue.isEmpty()) {
            QueueBean bean = queue.removeFirst();
            for (Edge e : graph.adj[bean.u]) {
                if (!e.isUse) continue;
                int other = e.other(bean.u);
                if (bean.sum + e.w > distTo[other]) continue;
                mark[other]++;
                queue.addLast(new QueueBean(other, bean.sum + e.w));
            }
        }
        for (int i = 1; i < mark.length; i++) {
            out.println(mark[i]);
        }
        out.close();

    }

    static class QueueBean {
        int u;
        int sum;

        public QueueBean(int u, int sum) {
            this.u = u;
            this.sum = sum;
        }
    }

    static class IndexMinPQ {
        int[] keys;
        int[] pq;
        int[] qp;
        int n;

        public IndexMinPQ(int capacity) {
            keys = new int[capacity + 1];
            pq = new int[capacity + 1];
            qp = new int[capacity + 1];

            for (int i = 0; i <= capacity; i++) {
                qp[i] = -1;
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public boolean contains(int i) {
            return qp[i] != -1;
        }

        public int size() {
            return n;
        }

        public int delMin() {
            int min = pq[1];
            exch(1, n--);
            sink(1);
            qp[min] = -1;        // delete
            pq[n + 1] = -1;        // not needed
            return min;
        }

        public void changeKey(int i, int val) {
            keys[i] = val;
            swim(qp[i]);
            sink(qp[i]);
        }

        private void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && greater(j, j + 1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public void insert(int i, int val) {
            n++;
            keys[i] = val;
            pq[n] = i;
            qp[i] = n;
            swim(n);
        }

        public void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        private void exch(int i, int j) {
            int swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }

        private boolean greater(int i, int j) {
            return keys[pq[i]] > keys[pq[j]];
        }
    }

    static class Graph {
        int V;
        ArrayList<Edge>[] adj;

        public Graph(int v) {
            V = v;
            adj = new ArrayList[V + 1];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void insertEdge(int u, int v, int w) {
            Edge e = new Edge(u, v, w);
            adj[u].add(new Edge(u, v, w));
            adj[v].add(new Edge(v, u, w));
        }
    }

    static class Node {
        int eIdx;
        Node next;

        public Node() {
        }

        public Node(int eIdx, Node next) {
            this.eIdx = eIdx;
            this.next = next;
        }
    }

    static class Edge {
        int u, v, w;
        boolean isUse;
        boolean isSelfCircle;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
            isSelfCircle = (u == v);
        }

        @Override
        public String toString() {
            return u + "->" + v + ";" + w;
        }

        public int other(int node) {
            if (u == node) return v;
            return u;
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
