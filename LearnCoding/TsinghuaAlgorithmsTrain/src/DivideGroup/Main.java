package DivideGroup;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
        }
        System.out.print(getAnser(n, m, value));

    }

    static long getAnser(int n, int m, int[] a) {
        long l = 1, r = 0, max = 0;
        for (int i = 0; i < n; ++i) {
            r += a[i];
            max = Math.max(a[i], max);
        }
        l = r % m == 0 ? (r / m) : (r / m + 1);
        r = max;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (check(mid, n, m, a)) r = mid - 1;
            else l = mid + 1;
        }
        return r + 1;
    }

    public static boolean check(long d, int n, int m, int[] a) {
        long sum = 0;
        int cut = 1;
        for (int i = 0; i < n; ++i) {
            if (a[i] > d) return false;
            sum += a[i];
            if (sum > d) {
                sum = a[i];
                cut++;
            }
        }
        return cut <= m;
    }

    public static int calThreshold(int sum, int m) {
        if (sum % m == 0) return sum / m;
        else return sum / m + 1;
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
