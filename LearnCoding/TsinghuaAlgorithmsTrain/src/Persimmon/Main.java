package Persimmon;

import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] uf = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
            size[i] = 1;
        }
        int count = n;
        int result = 0;
        MinPQ minPQ = new MinPQ(m);
        for (int i = 0; i < m; i++) {
            minPQ.insert(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        while (!minPQ.isEmpty()) {
            if (count == k) break;
            Edge e = minPQ.delMin();
            int rootP = find(uf, e.v);
            int rootQ = find(uf, e.w);
            if (rootP == rootQ) continue;

            union(uf, size, rootP, rootQ);
            count--;
            result += e.weight;
        }
        if (count == k)
            System.out.println(result);
        else
            System.out.println(-1);
    }

    public static int find(int[] uf, int p) {
        int temp = p;
        while (p != uf[p]) {
            p = uf[p];
        }
        while (temp != p) {
            int temp1 = uf[temp];
            uf[temp] = p;
            temp = temp1;
        }
        return p;
    }

    //return isConn
    public static void union(int[] uf, int[] size, int rootP, int rootQ) {
        if (size[rootP] < size[rootQ]) {
            uf[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            uf[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    static class Edge {
        int weight;
        int v;
        int w;

        public Edge(int v, int w, int weight) {
            this.weight = weight;
            this.v = v;
            this.w = w;
        }
    }

    static class MinPQ {
        Edge[] key;
        int n;

        public boolean isEmpty() {
            return n == 0;
        }

        public MinPQ(int capacity) {
            key = new Edge[capacity + 1];
            this.n = 0;
        }

        public void insert(Edge e) {
            key[++n] = e;
            swim(n);
        }

        public int size() {
            return n;
        }

        public Edge delMin() {
            Edge min = key[1];
            exch(1, n--);
            sink(1);
            key[n + 1] = null;
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

        public void swim(int k) {
            while (k > 1 && greater(k / 2, k)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        public void exch(int i, int j) {
            Edge temp = key[i];
            key[i] = key[j];
            key[j] = temp;
        }

        public boolean greater(int i, int j) {
            return key[i].weight > key[j].weight;
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
