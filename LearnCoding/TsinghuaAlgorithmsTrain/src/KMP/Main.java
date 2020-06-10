package KMP;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
//        int n = cin.nextInt();
//        String str = cin.next();
//        int m = cin.nextInt();
//        String pattern = cin.next();
//        match(out, str, pattern, n, m);
        kmp(out, "abcdabcdab", "cda", 10, 3);
        out.close();
//        System.out.println(Arrays.toString(buildNext("abcdabcdab")));
//        System.out.println(Arrays.toString(match("", "00001", 0, 5)));

    }

    public static int[] match(String A, String B, int n, int m) {
        int[] next = new int[m];
        int j = next[0] = -1;
        for (int i = 1; i < m; ++i) {
            while (j >= 0 && B.charAt(i) != B.charAt(j + 1))
                j = next[j];
            if (B.charAt(i) == B.charAt(j + 1))
                ++j;
            next[i] = j;
            if (j == m - 1) j = next[j];
        }
//        j = -1;
//        for (int i = 0; i < n; ++i) {
//            while (j >= 0 && A.charAt(i) != B.charAt(j + 1))
//                j = next[j];
//            if (A.charAt(i) == B.charAt(j + 1))
//                ++j;
//            if (j == m - 1) {
//
//                out.println(i - j);
//                j = next[j];
//            }
//        }
        return next;

    }

    public static void kmp(PrintWriter out, String T, String P, int n, int m) {
        int[] next = buildNext(P);
        int i = 0, j = 0;
        while (i < n) {
            if (j < 0 || T.charAt(i) == P.charAt(j)) {
                if (j == m - 1) {
                    out.println(i - j);
                    j = next[j];
                    continue;
                }
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
    }


    public static int[] buildNext(String p) {
        int[] N = new int[p.length()];
        N[0] = -1;
        int t = N[0], j = 0;
        while (j < p.length() - 1) {
            if (t < 0 || p.charAt(j) == p.charAt(t)) {
                N[++j] = ++t;
            } else {
                t = N[t];
            }
        }
        return N;
    }

    public static int[] buildNext1(String p) {
        int[] N = new int[p.length()];
        N[0] = -1;
        int t = N[0], j = 0;
        while (j < p.length() - 1) {
            if (t < 0 || p.charAt(j) == p.charAt(t)) {
                ++j;
                ++t;
                N[j] = p.charAt(j) == p.charAt(t) ? N[t] : t;
            }
        }
        return N;
    }
}
