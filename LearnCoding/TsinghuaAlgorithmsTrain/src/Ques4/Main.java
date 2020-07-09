package Ques4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static final long mo1 = (long) 1e9 + 7;
    static final long mo2 = (long) 1e9 + 9;
    static final long b1 = 233;
    static final long b2 = 956;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        String s = in.next();
        int threshold = in.nextInt();
        long[] hash1 = new long[s.length() + 3];
        long[] hash2 = new long[s.length() + 3];
        long[] pw1 = new long[s.length() + 3];
        long[] pw2 = new long[s.length() + 3];
        //计算hash
        long t1 = 0, t2 = 0;
        for (int i = s.length(); i >= 1; i--) {
            int val = s.charAt(i - 1) - 'a';
            hash1[i] = t1 = (t1 * b1) % mo1 + val;
            hash2[i] = t2 = (t2 * b2) % mo2 + val;
        }

        long p1 = 1;
        long p2 = 1;
        for (int len = 1; len <= s.length(); len++) {
            pw1[len] = p1 = (p1 * b1) % mo1;
            pw2[len] = p2 = (p2 * b2) % mo2;
        }
        HashMap<Long, Integer> map1 = new HashMap<>();
        HashMap<Long, Integer> map2 = new HashMap<>();
        int l = 1, r = s.length();
        while (l <= r) {
            map1.clear();
            map2.clear();
            int len = (l + r) / 2;
            int max1 = 0, max2 = 0;
            for (int j = 1; j + len - 1 <= s.length(); j++) {
                long val1 = (hash1[j] - pw1[len] * hash1[j + len]) % mo1;
                val1 = (val1 + mo1) % mo1;
                long val2 = (hash2[j] - pw2[len] * hash2[j + len]) % mo2;
                val2 = (val2 + mo2) % mo2;
                map1.put(val1, map1.getOrDefault(val1, 0) + 1);
                map2.put(val2, map2.getOrDefault(val2, 0) + 1);
                max1 = Math.max(max1, map1.get(val1));
                max2 = Math.max(max2, map2.get(val2));
            }
            if (max1 == max2 && max1 >= threshold) l = len + 1;
            else r = len - 1;
        }
        out.println(l - 1);
        out.close();
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
