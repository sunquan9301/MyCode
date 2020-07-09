package ClosestPoints;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class Main {

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

        final int N = 300005;

        // 用于存储一个二维平面上的点
        class ip {
            int x, y;

            // 构造函数
            ip(int x, int y) {
                this.x = x;
                this.y = y;
            }

        }

        ip[] a = new ip[N];
        ip[] b = new ip[N];

        // 计算x的平方
        long sqr(long x) {
            return x * x;
        }

        // 计算点a和点b的距离
        double dis(ip a, ip b) {
            return sqrt(sqr(a.x - b.x) + sqr(a.y - b.y));
        }

        double ans;
        /* 请在这里定义你需要的全局变量 */

        // 计算最近点对的距离
        // n：n个点
        // X, Y：分别表示x轴坐标和y轴坐标，下标从0开始
        // 返回值：最近的距离
        double getAnswer(int n, int[] X, int[] Y) {
            /* 请在这里设计你的算法 */
            for (int i = 0; i < n; i++)
                a[i + 1] = new ip(X[i], Y[i]);
            ans = 1e100;
            Arrays.sort(a, 1, n + 1, new Comparator<ip>() {
                @Override
                public int compare(ip a, ip b) {
                    if (a.x < b.x) return -1;
                    else if (a.x > b.x) return 1;
                    else {
                        if (a.y < b.y) return -1;
                        else if (a.y > b.y) return 1;
                        return 0;
                    }
                }
            });
            solve(1, n);
            return ans;
        }

        void solve(int l, int r) {
            if (r - l <= 1) {
                if (a[l].y > a[r].y) {
                    ip temp = a[l];
                    a[l] = a[r];
                    a[r] = temp;
                }
                if (r != l) {
                    ans = min(ans, dis(a[l], a[r]));
                }
                return;
            }
            int mid = (l + r) >> 1;
            int md = a[mid].x;
            solve(l, mid);
            solve(mid + 1, r);
            int cnt = 0;
            for (int i = l, j = mid + 1; i <= mid || j <= r; ) {
                for (; i <= mid && md - a[i].x >= ans; ++i) ;
                for (; j <= r && a[j].x - md >= ans; ++j) ;
                if (i <= mid && (j > r || a[i].y < a[j].y))
                    b[cnt++] = a[i++];
                else if (j <= r)
                    b[cnt++] = a[j++];
            }
            for (int i = 0; i < cnt; ++i)
                for (int j = i + 1; j < cnt && b[j].y - b[i].y < ans; ++j)
                    ans = min(ans, dis(b[i], b[j]));
            cnt = 0;
            for (int i = l, j = mid + 1; i <= mid || j <= r; ) {
                if (i <= mid && (j > r || a[i].y < a[j].y))
                    b[cnt++] = a[i++];
                else if (j <= r)
                    b[cnt++] = a[j++];
            }
            for (int i = 0; i < cnt; ++i)
                a[l + i] = b[i];
        }

        // ================= 代码实现结束 =================

        void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] X = new int[n];
            int[] Y = new int[n];
            for (int i = 0; i < n; ++i) {
                X[i] = in.nextInt();
                Y[i] = in.nextInt();
            }
            out.printf("%.2f\n", getAnswer(n, X, Y));
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