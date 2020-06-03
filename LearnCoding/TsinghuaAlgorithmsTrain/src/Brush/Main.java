package Brush;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader cin = new InputReader(inputStream);
        int m = cin.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) a[i] = cin.nextInt();
        int[] b = new int[6];
        for (int i = 0; i < m; ++i) b[a[i]]++;
        int[][][][][][] f = new int[21][21][21][21][21][6];
        int N = 21;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                for (int k = 0; k < N; ++k)
                    for (int l = 0; l < N; ++l)
                        for (int p = 0; p < N; ++p)
                            for (int q = 0; q < 6; ++q)
                                f[i][j][k][l][p][q] = -1;
        System.out.println(dp(b[1], b[2], b[3], b[4], b[5], 0, f) % 23333);

    }

    static long dp(int a, int b, int c, int d, int e, int last, int[][][][][][] f) {
        if ((a | b | c | d | e) == 0) return 1;
        if (f[a][b][c][d][e][last] != -1) return f[a][b][c][d][e][last];
        long ret = 0;
        if (a != 0)
            ret += (dp(a - 1, b, c, d, e, 1, f) * (a - (last == 2 ? 1 : 0)));
        if (b != 0)
            ret += (dp(a + 1, b - 1, c, d, e, 2, f) * (b - (last == 3 ? 1 : 0)));
        if (c != 0)
            ret += (dp(a, b + 1, c - 1, d, e, 3, f) * (c - (last == 4 ? 1 : 0)));
        if (d != 0)
            ret += (dp(a, b, c + 1, d - 1, e, 4, f) * (d - (last == 5 ? 1 : 0)));
        if (e != 0)
            ret += (dp(a, b, c, d + 1, e - 1, 5, f) * e);
        f[a][b][c][d][e][last] = (int) (ret % 23333);
        return (int) (ret % 23333);

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
