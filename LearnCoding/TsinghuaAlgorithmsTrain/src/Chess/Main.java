package Chess;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static int N = 505 * 2;
    final static int M = N * N;
    static int cnt;
    static int[] ihead = new int[N];
    static int[] mc = new int[N];
    static boolean[] vis = new boolean[N];
    static E[] e = new E[M];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] value = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                value[i][j] = cin.nextInt();
            }
        }
        System.out.println(getAnswer(n, value));

    }

    static boolean dfs(int x) {
        for (int i = ihead[x]; i != 0; i = e[i].next) {
            int y = e[i].to;
            if (!vis[y]) {
                vis[y] = true;
                if (mc[y] == 0 || dfs(mc[y])) {
                    mc[x] = y;
                    mc[y] = x;
                    return true;
                }
            }
        }
        return false;
    }

    static int getAnswer(int n, int[][] board) {
        cnt = 0;
        for (int i = 1; i <= n * 2; ++i) {
            ihead[i] = 0;
            mc[i] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (board[i - 1][j - 1] == 1) {
                    add(i, j+n);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (mc[i] == 0) {
                Arrays.fill(vis, false);
                if (dfs(i)) ++ans;
            }
        }

        return ans;
    }

    static void add(int x, int y) {
        ++cnt;
        if (e[cnt] == null) {
            e[cnt] = new E();
        }
        e[cnt].next = ihead[x];
        e[cnt].to = y;
        ihead[x] = cnt;
    }

    static class E {
        int next, to;
    }
}
