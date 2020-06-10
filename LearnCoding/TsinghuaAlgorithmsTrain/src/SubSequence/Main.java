package SubSequence;

import java.util.Scanner;

public class Main {
    static int mo = 23333;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        int n = s.length();
        s = 'A' + s;
        int[] last = new int[26];
        long[] f = new long[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= s.length() - 1; ++i) {
            int a = s.charAt(i) - 'a';
            p[i] = last[a];
            last[a] = i;
        }
        for (int i = 1; i <= n; ++i) {
            f[i] = (f[i - 1] % mo + f[i - 1] % mo) % mo;
//            if (i == 17) {
//                System.out.println("i = " + i + ",f[i] = " + f[i] + "f[i-1]= " + f[i - 1]);
//            }
            if (p[i] == 0) f[i] = (f[i] + 1L) % mo;
            else {
//                if (i == 17) {
//                    System.out.println("i = " + i + ",f[p[i] - 1] = " + f[p[i] - 1]);
//                }
                f[i] = mod((f[i] - f[p[i] - 1]), mo);
            }
//            if (f[i] < 0) {
//                System.out.println("i = " + i + ",f[i] = " + f[i] + "f[i-1]= " + f[i - 1]);
//                break;
//            }
        }
        System.out.println(f[n]);
    }

    public static long mod(long k, int r) {
        if (k >= 0) return k % r;
        else {
            int sum = r;
            int count = 1;
            while (k < sum) {
                sum = -Math.abs(sum * count);
                count++;
            }
            return k - sum;
        }
    }
}
