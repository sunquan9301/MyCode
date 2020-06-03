package CowEatGrass;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int[] x = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            x[i] = cin.nextInt();
        }
        System.out.println(getAnswer(n, k, x));
    }

    static int getAnswer(int n, int k, int[] x) {
        Arrays.sort(x);
        int[][][] dp = new int[2002][2002][2];
        for (int i = 1; i <= n; ++i)
            dp[i][i][0] = dp[i][i][1] = Math.abs(k - x[i]) * n;
        for (int len = 1; len < n; ++len) {
            for (int l = 1, r; (r = l + len) <= n; ++l) {
                dp[l][r][0] = Math.min(dp[l + 1][r][0] + (n - r + l) * Math.abs(x[l] - x[l + 1]), dp[l + 1][r][1] + (n - r + l) * Math.abs(x[l] - x[r]));
                dp[l][r][1] = Math.min(dp[l][r - 1][1] + (n - r + l) * Math.abs(x[r] - x[r - 1]), dp[l][r - 1][0] + (n - r + l) * Math.abs(x[r] - x[l]));
            }
        }
        return Math.min(dp[1][n][0], dp[1][n][1]);
    }

}
