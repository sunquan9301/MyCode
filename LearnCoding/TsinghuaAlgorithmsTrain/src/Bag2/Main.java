package Bag2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader cin = new InputReader(inputStream);
        n = cin.nextInt();
        int[] vSet = new int[n + 1];
        int[] wSet = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            vSet[i] = cin.nextInt();
            wSet[i] = cin.nextInt();
        }

        int q = cin.nextInt();
        int[] qV = new int[q + 1];
        int[] qIndex = new int[q + 1];
        for (int i = 1; i <= q; i++) {
            qV[i] = cin.nextInt();
            qIndex[i] = cin.nextInt();
        }

        int[][] d = new int[5005][5005];
        int[][] f = new int[5005][5005];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < vSet[i]; ++j)
                d[i][j] = d[i - 1][j];
            for (int j = vSet[i]; j <= 5000; ++j) {
                d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - vSet[i]] + wSet[i]);
            }
        }
        for (int i = n; i >= 1; --i) {
            for (int j = 0; j < vSet[i]; ++j)
                f[i][j] = f[i + 1][j];
            for (int j = vSet[i]; j <= 5000; ++j) {
                f[i][j] = Math.max(f[i + 1][j], f[i + 1][j - vSet[i]] + wSet[i]);
            }
        }

        for (int i = 1; i <= q; i++) {
            int V = qV[i];
            int x = qIndex[i];
            int mx = 0;
            for (int j = 0; j <= V; j++) {
                mx = Math.max(mx, d[x - 1][j] + f[x + 1][V - j]);
            }
            System.out.println(mx);
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
