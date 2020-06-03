package Brush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int m;
    static int sum;
    static int result;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader cin = new InputReader(inputStream);
        m = cin.nextInt();
        int[] val = new int[m];
        sum = 0;
        for (int i = 0; i < m; i++) {
            val[i] = cin.nextInt();
            sum += val[i];
        }
        int[] cars = new int[sum];
        solve(val, 0, cars);
        System.out.println(result);
    }

    public static void solve(int[] val, int count, int[] cars) {
        if (count == sum) {
            result++;
            return;
        }
        for (int i = 0; i < val.length; i++) {
            if ((count > 0 && cars[count - 1] == i) || val[i] == 0) continue;
            cars[count++] = i;
            val[i]--;
            solve(val, count, cars);
            val[i]++;
            if (count > 0) count--;
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
