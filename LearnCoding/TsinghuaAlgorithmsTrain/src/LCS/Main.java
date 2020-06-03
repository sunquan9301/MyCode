package LCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int inf = (int) 1e9;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; ++i) a[i] = cin.nextInt();
        for (int i = 1; i <= n; ++i) b[i] = cin.nextInt();
        System.out.println(LCS(n, a, b));
//        LCS(n, a, b);
    }

    public static int LCS(int n, int[] a, int[] b) {
        int[] pos = new int[n + 1];
        int[] f = new int[n + 2];
        for (int i = 0; i < n + 2; i++) f[i] = inf;
        for (int i = 1; i <= n; ++i) pos[b[i]] = i;
        for (int i = 1; i <= n; ++i) {
            a[i] = pos[a[i]];
        }
        f[0] = 0;
        for (int i = 1; i <= n; ++i) {
            f[lowerBound(f, n, a[i])] = a[i];
        }
//        System.out.println(Arrays.toString(f));
        return lowerBound(f, n, n + 1) - 0 - 1;

    }

    public static int lowerBound(int[] f, int n, int a) {
        int l = 1, r = n + 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a <= f[m]) r = m - 1;
            else l = m + 1;
        }
        return r + 1;
    }

    public static int upperBound(int[] f, int n, int a) {
        int l = 1, r = n + 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a < f[m]) r = m - 1;
            else l = m + 1;
        }
        return r + 1;
    }
}
