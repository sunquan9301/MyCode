package MinimumSwap;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        int[] value = new int[n];
        int[] value1 = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
            value1[i] = value[i];
        }
        System.out.println(solve(0, n - 1, value, temp));
//        System.out.println(Arrays.toString(value));


//        System.out.println(solve(value1));
//        System.out.println(Arrays.toString(value1));

    }

    public static long solve(int lo, int hi, int[] value, int[] temp) {
        if (lo == hi) return 0;
        int mid = (lo + hi) / 2;
        long result = solve(lo, mid, value, temp) + solve(mid + 1, hi, value, temp);
        return result + merge(lo, mid, hi, value, temp);
    }

    public static long merge(int lo, int mid, int hi, int[] value, int[] temp) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = value[i];
        }
        long result = 0;
        for (int i = mid + 1; i <= hi; i++) {
            result += cal(value[i], lo, mid, value);
        }
        int p = lo, q = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (p > mid) value[i] = temp[q++];
            else if (q > hi) value[i] = temp[p++];
            else value[i] = temp[p] > temp[q] ? temp[q++] : temp[p++];
        }
        return result;
    }

    public static long cal(int val, int lo, int hi, int[] value) {
        int i;
        for (i = lo; i <= hi; i++) {
            if (val < value[i]) break;
        }
        return hi - i + 1;
    }

    public static long solve(int[] value) {
        long result = 0;
        int j;
        for (int i = 1; i < value.length; i++) {
            for (j = i; j > 0 && value[j] < value[j - 1]; j--) {
                swap(j, j - 1, value);
                result++;
            }
        }
        return result;
    }

    public static void swap(int a, int b, int[] value) {
        int temp = value[a];
        value[a] = value[b];
        value[b] = temp;
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
