package WeekTest2;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        InputReader in = new InputReader(inputStream);
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int[] value = new int[n];
//        for (int i = 0; i < n; i++) {
//            value[i] = cin.nextInt();
//        }
//        System.out.print(solve(value));
//        System.out.print(Integer.MAX_VALUE);
        long all = 0;
        all = 65536l * 65536l;
        System.out.print(all);
//        System.out.print(solve(new int[]{2}));
    }

    public static long solve(int[] value) {
        //归并排序
        int N = value.length;
        int[] temp = new int[value.length];
        long result = 0;
        for (int gap = 1; gap < N; gap += gap)
            for (int j = 0; j < N - gap; j = j + 2 * gap)
                result = result + merge(j, j + gap - 1, Math.min(j + 2 * gap - 1, N - 1), value, temp);
        return result;
    }

    public static long merge(int lo, int mid, int hi, int[] value, int[] temp) {
        long all = 0, result = 0;
        int index = lo, p = lo, q = mid + 1;
        for (int i = mid + 1; i <= hi; i++) {
            all = all + mid - lo + 1;
            index = cal(value[i], index, mid, value);
            result = result + mid - index + 1;
        }
        result = (all - result) <= result ? (all - result) : result;
        for (int i = lo; i <= hi; i++) temp[i] = value[i];
        for (int i = lo; i <= hi; i++)
            if (p > mid) value[i] = temp[q++];
            else if (q > hi) value[i] = temp[p++];
            else value[i] = temp[p] > temp[q] ? temp[q++] : temp[p++];
        return result;
    }

    //从左往右遍历，找到第一个逆序对时的 A,的索引
    public static int cal(int val, int lo, int mid, int[] value) {
        int j = lo;
        for (j = lo; j <= mid; j++) if (val < value[j]) break;
        return j;
    }

    public static int binarySearch(int x, int lo, int hi, int[] value) {
        if (lo == hi) return x < value[lo] ? lo : lo + 1;
        int mid = (lo + hi) / 2;
        if (x > value[mid]) return binarySearch(x, mid + 1, hi, value);
        else return binarySearch(x, lo, mid, value);
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
