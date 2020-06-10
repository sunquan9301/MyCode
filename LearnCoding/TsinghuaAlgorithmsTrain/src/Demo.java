import java.io.*;
import java.util.StringTokenizer;

public class Demo {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {

        // ================= 代码实现开始 =================

        final int N = 500005, mo = 23333;
        /* 请在这里定义你需要的全局变量 */

        // 为了减少复制开销，我们直接读入信息到全局变量中
        // s：题目所给字符串，下标从1开始
        // n：字符串长度
        int n;
        char[] s;
        int[] last;
        long[] dp;

        // 求出字符串s有多少不同的子序列
        // 返回值：s不同子序列的数量，返回值对mo取模
        int getAnswer() {
            /* 请在这里设计你的算法 */
            last = new int[N];
            dp = new long[N];
            dp[0] = 1;
            for(int i=1; i<=n; i++){
                int j = last[(int)s[i]];
                dp[i] = 2 * dp[i-1];
                if(j != 0){
                    dp[i] -= dp[j-1];
                }
                dp[i] %= mo;
                last[(int)s[i]] = i;
            }
            return (int)(dp[n]+mo -1)%mo;
        }



        // ================= 代码实现结束 =================

        void solve(InputReader in, PrintWriter out) {
            String _s = in.next();
            n = _s.length();
            s = new char[n + 1];
            for (int i = 0; i < n; ++i)
                s[i + 1] = _s.charAt(i);
            out.println(getAnswer());
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
