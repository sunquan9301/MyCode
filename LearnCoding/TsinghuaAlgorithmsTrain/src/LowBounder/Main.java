package LowBounder;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
//        int[] value = new int[]{0,132, 34, 02, 129, 458, 1090, 24, 2049, 39, 845};
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++)
            value[i] = in.nextInt();
        for (int i = value.length / 2; i >= 1; i--) {
            sink(i, value, value.length - 1);
        }
        int len = value.length - 1;
        while (len > 1) {
            swap(1, len, value);
            len--;
            sink(1, value, len);
        }


        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int index = queryNextValue(in.nextInt(), 1, value.length - 1, value);
            out.println(index >= value.length ? -1 : value[index]);
        }
        out.close();
    }

    public static int queryNextValue(int x, int lo, int hi, int[] value) {
        if (lo == hi) return x <= value[lo] ? lo : lo + 1;
        int mid = (lo + hi) / 2;
        if (x == value[mid]) return mid;
        else if (x > value[mid]) return queryNextValue(x, mid + 1, hi, value);
        else return queryNextValue(x, lo, mid, value);
    }

    public static void sink(int k, int[] value, int len) {
        while (2 * k <= len) {
            int j = 2 * k;
            if (j < len && value[j] < value[j + 1]) j++;
            if (value[k] < value[j]) swap(k, j, value);
            k = j;
        }
    }

    public static void swap(int p, int q, int[] value) {
        int temp = value[p];
        value[p] = value[q];
        value[q] = temp;
    }


    static class MaxPQ {
        int[] key;
        int n;

        public boolean isEmpty() {
            return n == 0;
        }

        public MaxPQ(int capacity) {
            key = new int[capacity + 1];
            this.n = 0;
        }

        public void insert(int e) {
            key[++n] = e;
            swim(n);
        }

        public int size() {
            return n;
        }

        public int delMax() {
            int max = key[1];
            exch(1, n--);
            sink(1);
            key[n + 1] = -1;
            return max;
        }

        public void sink(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && small(j, j + 1)) j++;
                if (!small(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public void swim(int k) {
            while (k > 1 && !small(k, k / 2)) {
                exch(k, k / 2);
                k = k / 2;
            }
        }

        public void exch(int i, int j) {
            int temp = key[i];
            key[i] = key[j];
            key[j] = temp;
        }

        public boolean small(int i, int j) {
            return key[i] < key[j];
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
