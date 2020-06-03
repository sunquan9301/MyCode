package DropWater;

import java.util.Scanner;

public class Main {
    static class pii {
        int fi;
        int se;

        public pii() {
            fi = 0;
            se = 0;
        }

        public pii(int fi, int se) {
            this.fi = fi;
            this.se = se;
        }
    }

    static int N = 2003;
    static int[][] mind = new int[N][N];
    static pii[] q = new pii[N * N];
    static int qh, qt;

    static int getAnswer(int n, int m, int t, int d) {
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                mind[i][j] = -1;
        qh = qt = 0;
        q[++qt] = new pii(0, 0);
        mind[0][0] = 0;
        while (qh < qt) {
            pii u = q[++qh];
            if (mind[u.fi][u.se] == t) break;
            for (int k = 0; k < 6; ++k) {
                pii v = to(u, k, n, m);
                if (mind[v.fi][v.se] != -1)
                    continue;
                q[++qt] = v;
                mind[v.fi][v.se] = mind[u.fi][u.se] + 1;
            }
        }
        int ans = d;
        for (int i = 0; i <= n; ++i)
            for (int j = 0; j <= m; ++j)
                if (mind[i][j] != -1)
                    ans = Math.min(ans, Math.abs(i + j - d));
        return ans;
    }

    static pii to(pii p, int k, int n, int m) {
        if (k == 0) return new pii(0, p.se);
        else if (k == 1) return new pii(p.fi, 0);
        else if (k == 2) return new pii(n, p.se);
        else if (k == 3) return new pii(p.fi, m);
        else if (k == 4) return new pii(Math.min(n, p.fi + p.se), Math.max(0, p.fi + p.se - n));
        else if (k == 5) return new pii(Math.max(0, p.fi + p.se - m), Math.min(m, p.fi + p.se));
        else return p;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int t = cin.nextInt();
        int d = cin.nextInt();
        System.out.println(getAnswer(n, m, t, d));

    }

}
