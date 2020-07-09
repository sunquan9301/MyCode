package WeekTest4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        String s = in.next();
        int n = in.nextInt();
        ArrayList<String>[] suffixCharMapString = new ArrayList[26];
        for (int i = 0; i < 26; i++) suffixCharMapString[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            suffixCharMapString[str.charAt(str.length() - 1) - 'a'].add(str);
        }
        long[] dp = new long[s.length() + 3];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++)
            for (String ss : suffixCharMapString[s.charAt(i - 1) - 'a'])
                if (i - ss.length() < 0) continue;
                else if (!s.substring(i - ss.length(), i).equals(ss)) continue;
                else dp[i] = (dp[i] + dp[i - ss.length()]) % 23333;
        System.out.println(dp[s.length()]);

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
