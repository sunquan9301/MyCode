package NumberTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader cin = new InputReader(inputStream);
        int n = cin.nextInt();
        long[][] value = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                value[i][j] = cin.nextInt();
            }
        }
        for (int i = 1; i < n; i++)
            for (int j = 0; j <= i; j++)
                value[i][j] = j == 0 ? (value[i - 1][j] + value[i][j]) : (Math.max(value[i - 1][j], value[i - 1][j - 1]) + value[i][j]);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, value[n - 1][i]);
        }
        System.out.println(result);
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
