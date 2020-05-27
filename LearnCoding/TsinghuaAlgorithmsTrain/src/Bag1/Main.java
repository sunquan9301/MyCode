package Bag1;

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
        int w = cin.nextInt();
        int[] type = new int[n + 1];
        int[] vSet = new int[n + 1];
        int[] wSet = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            type[i] = cin.nextInt();
            vSet[i] = cin.nextInt();
            wSet[i] = cin.nextInt();
        }
        int[][] vw = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            if (type[i] == 0) {
                for (int j = 1; j <= w; j++) {
                    vw[i][j] = Math.max(vw[i - 1][j], j - wSet[i] >= 0 ? (vw[i - 1][j - wSet[i]] + vSet[i]) : vw[i - 1][j]);
                }
            } else {
                for (int j = 1; j <= w; j++) {
                    int result = 0, count = 0;
                    int tempW = j;
                    while (tempW >= 0) {
                        result = Math.max(result, vw[i - 1][tempW] + count * vSet[i]);
                        tempW = tempW - wSet[i];
                        count++;
                    }
                    vw[i][j] = result;
                }
            }
        }
        int result = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
//                System.out.print(vw[i][j] + "     ");
                result = Math.max(result, vw[i][j]);
            }
//            System.out.println();
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
