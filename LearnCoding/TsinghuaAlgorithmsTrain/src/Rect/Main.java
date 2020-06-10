package Rect;

import java.util.Scanner;

public class Main {
    static final int N = 1005;
    static final long mo1 = (long) 1e9 + 7;
    static final long mo2 = (long) 1e9 + 9;
    static final long pw = 233;

    static long[][][] h1 = new long[2][N][N];
    static long[][][] h2 = new long[2][N][N];
    static long[][][] bb = new long[2][N][N];

    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];
    static int n, m, p, q;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        p = cin.nextInt();
        q = cin.nextInt();
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j)
                a[i][j] = cin.nextInt();
        for (int i = 1; i <= p; ++i)
            for (int j = 1; j <= q; ++j)
                b[i][j] = cin.nextInt();
        long p1 = 1L, p2 = 1L;
        for (int i = 1; i <= q; ++i) {
            p1 = p1 * pw % mo1;
            p2 = p2 * pw % mo2;
        }
        p1 = (mo1 - p1) % mo1;
        p2 = (mo2 - p2) % mo2;
        for (int i = 1; i <= n; ++i) {
            long t1 = 0L, t2 = 0L;
            for (int j = 1; j <= m; ++j) {
                if (j < q) {
                    t1 = (t1 * pw + a[i][j]) % mo1;
                    t2 = (t2 * pw + a[i][j]) % mo2;
                } else {
                    t1 = h1[0][i][j] = (t1 * pw + a[i][j] + p1 * a[i][j - q]) % mo1;
                    t2 = h2[0][i][j] = (t2 * pw + a[i][j] + p2 * a[i][j - q]) % mo2;
                }
            }
        }
        p1 = 1L;
        p2 = 1L;
        for (int i = 1; i <= p; ++i) {
            p1 = p1 * pw % mo1;
            p2 = p2 * pw % mo2;
        }
        p1 = (mo1 - p1) % mo1;
        p2 = (mo2 - p2) % mo2;
        for (int j = 1; j <= m; ++j) {
            long t1 = 0, t2 = 0;
            for (int i = 1; i <= n; ++i) {
                if (i < p) {
                    t1 = (t1 * pw + h1[0][i][j]) % mo1;
                    t2 = (t2 * pw + h2[0][i][j]) % mo2;
                } else {
                    t1 = h1[1][i][j] = (t1 * pw + h1[0][i][j] + p1 * h1[0][i - p][j]) % mo1;
                    t2 = h2[1][i][j] = (t2 * pw + h2[0][i][j] + p2 * h2[0][i - p][j]) % mo2;
                }
            }
        }
        for (int i = 1; i <= p; ++i)
            for (int j = 1; j <= q; ++j) {
                bb[0][i][j] = (bb[0][i][j - 1] * pw + b[i][j]) % mo1;
                bb[1][i][j] = (bb[1][i][j - 1] * pw + b[i][j]) % mo2;
            }
        p1 = p2 = 0;
        for (int i = 1; i <= p; ++i) {
            p1 = (p1 * pw + bb[0][i][q]) % mo1;
            p2 = (p2 * pw + bb[1][i][q]) % mo2;
        }

        for (int i = p; i <= n; ++i)
            for (int j = q; j <= m; ++j) {
                if (h1[1][i][j] == p1 && h2[1][i][j] == p2)
                    System.out.println((i - p + 1) + " " + (j - q + 1));
            }

    }
}
