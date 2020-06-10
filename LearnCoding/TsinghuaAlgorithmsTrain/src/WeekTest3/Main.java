package WeekTest3;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader cin = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) solve(cin, out);
        out.close();

    }

    public static void solve(InputReader cin, PrintWriter out) {
        int n = cin.nextInt();
        long S = cin.nextLong();
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            A[i] = cin.nextInt();
        }
        for (int i = 1; i <= n; ++i) {
            B[i] = cin.nextInt();
        }
        ArrayDeque<ValueBean> queue = new ArrayDeque<>();
        ArrayDeque<ValueBean> queue1 = new ArrayDeque<>();
        queue.push(new ValueBean(0L, 0));

        while (!queue.isEmpty()) {
            if (queue.getFirst().index == n / 2) break;
            ValueBean valueBean = queue.removeFirst();
            int curIdx = valueBean.index + 1;
            long valueA = A[curIdx];
            long valueB = B[curIdx];
            queue.addLast(new ValueBean(valueBean.value + A[curIdx], valueBean.index + 1));
            queue.addLast(new ValueBean(valueBean.value + B[curIdx], valueBean.index + 1));
            queue.addLast(new ValueBean(valueBean.value + valueA * valueB, valueBean.index + 1));
        }
        queue1.push(new ValueBean(0L, n / 2));
        while (!queue1.isEmpty()) {
            if (queue1.getFirst().index == n) break;
            ValueBean valueBean = queue1.removeFirst();
            int curIdx = valueBean.index + 1;
            long valueA = A[curIdx];
            long valueB = B[curIdx];
            queue1.addLast(new ValueBean(valueBean.value + A[curIdx], valueBean.index + 1));
            queue1.addLast(new ValueBean(valueBean.value + B[curIdx], valueBean.index + 1));
            queue1.addLast(new ValueBean(valueBean.value + valueA * valueB, valueBean.index + 1));
        }

        HashSet<Long> set = new HashSet<>();
        while (!queue.isEmpty()) {
            set.add(queue.removeFirst().value);
        }
        while (!queue1.isEmpty()) {
            if (set.contains(S - queue1.removeFirst().value)) {
                out.println(1);
                return;
            }
        }
        out.println(0);
    }

    static class ValueBean {
        Long value;
        int index;

        public ValueBean(Long value, int index) {
            this.value = value;
            this.index = index;
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
