package DropWater;

import java.util.Scanner;

public class Main1 {
    static int n, m, t, d;
    static int result = Integer.MAX_VALUE;
    static int a, b;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        t = cin.nextInt();
        d = cin.nextInt();
        int[][] mind = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i)
            for (int j = 0; j <= m; ++j)
                mind[i][j] = -1;
        int[] aArr = new int[t];
        int[] bArr = new int[t];
        int[] opt = new int[t];
        solve(mind, aArr, bArr, opt, 0);
        System.out.println(result);
    }

    public static void solve(int[][] mind, int[] aArr, int[] bArr, int[] opt, int count) {
        if (count == t) {
            result = Math.min(result, Math.abs(a + b - d));
            return;
        }
        for (int i = 0; i < 7; i++) {
            if (count > 0 && opt[count - 1] == i) continue;
            if (a == n && (i == 1 || i == 4)) continue;
            if (b == m && (i == 1 || i == 5)) continue;
            if (a == 0 && (i == 0 || i == 5)) continue;
            if (b == 0 && (i == 3 || i == 4)) continue;
            doAction(i);
            if (mind[a][b] != -1) continue;
            mind[a][b] = count;
            aArr[count] = a;
            bArr[count] = b;
            opt[count] = i;
            count++;
            solve(mind, aArr, bArr, opt, count);
            count--;
            a = aArr[count];
            b = bArr[count];
        }

    }


    public static void doAction(int type) {
        if (type == 6) return;
        else if (type == 0) a = n;
        else if (type == 1) b = m;
        else if (type == 2) a = 0;
        else if (type == 3) b = 0;
        else if (type == 4) {
            if (a + b >= n) {
                a = n;
                b = a + b - n;
            } else {
                a = a + b;
                b = 0;
            }
        } else if (type == 5) {
            if (a + b >= m) {
                b = m;
                a = a + b - m;
            } else {
                b = a + b;
                a = 0;
            }
        }
    }
}
