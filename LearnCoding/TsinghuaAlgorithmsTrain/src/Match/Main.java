package Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] mark = new int[n + 1][6];
        int[] a = new int[5 * n + 1];
        int[] b = new int[5 * n + 1];
        for (int i = 1; i <= 5 * n; ++i) a[i] = cin.nextInt();
        for (int i = 1; i <= 5 * n; ++i) {
            b[i] = cin.nextInt();
            mark[b[i]][0]++;
            mark[b[i]][mark[b[i]][0]] = i;
        }
        pii[] arr = new pii[25 * n];
        int count = 0;
        for (int i = 1; i <= 5 * n; ++i) {
            arr[count++] = new pii(i, mark[a[i]][1]);
            arr[count++] = new pii(i, mark[a[i]][2]);
            arr[count++] = new pii(i, mark[a[i]][3]);
            arr[count++] = new pii(i, mark[a[i]][4]);
            arr[count++] = new pii(i, mark[a[i]][5]);
        }

        System.out.println(longestSubString1(arr));
//        LCS(n, a, b);
    }

    static int longestSubString1(pii[] arr) {
        pii[] h = new pii[arr.length];
        h[0] = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (greater(arr[i], h[max])) {
                h[++max] = arr[i];
                continue;
            } else {
                int pos = findFirstBigger(h, 0, max, arr[i]);
                h[pos] = arr[i];
            }
        }
        return max + 1;
    }

    static int findFirstBigger(pii[] h, int left, int right, pii target) {
        if (left == right) return left;
        int mid = (left + right) / 2;
        if (greater(target, h[mid]))
            return findFirstBigger(h, mid + 1, right, target);
        else
            return findFirstBigger(h, left, mid, target);
    }

    static int longestSubString(pii[] arr) {
        int len = 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (greater(arr, i, j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            len = Math.max(dp[i], len);
        }
        return len;
    }

    private static boolean greater(pii a, pii b) {
        return a.x > b.x && a.y > b.y;
    }

    private static boolean greater(pii[] arr, int i, int j) {
        return arr[i].x > arr[j].x && arr[i].y > arr[j].y;
    }

    static class pii {
        int x;
        int y;

        public pii(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
