

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 1003;
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Pair[] a = new Pair[n + 1];
        for (int i = 1; i <= n; i++) a[i] = new Pair(cin.nextInt(), cin.nextInt());
        int ans = 0;
        for (int round = 0; round < 2; ++round) {
            Arrays.sort(a, 1, a.length);
            for (int i = 1; i <= n; ++i) {
                dp[i][i] = a[i].second;
                for (int j = 1; j < i; ++j) {
                    dp[i][j] = 0;
                    for (int k = j; k > 0 && 2 * a[j].first <= a[i].first + a[k].first; --k)
                        dp[i][j] = Math.max(dp[i][j], dp[j][k]);
                    ans = Math.max(ans, (dp[i][j] += a[i].second));
                }
            }
            for (int i = 1; i <= n; ++i) a[i].first = -a[i].first;
        }
        System.out.println(ans);
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return first - o.first;
        }
    }
}
