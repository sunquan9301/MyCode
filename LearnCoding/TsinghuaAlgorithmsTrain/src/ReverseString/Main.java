package ReverseString;

import java.util.Scanner;

public class Main {

    static final int N = 500005;
    static char[] s = new char[N * 2];
    static int[] len = new int[N * 2];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println(getAnswer(cin.next()));
    }

    static long getAnswer(String str) {
        int n = str.length();
        for (int i = n; i != 0; --i) {
            s[i << 1] = str.charAt(i - 1);
            s[i << 1 | 1] = 0;
        }
        n = n << 1 | 1;
        s[1] = 0;
        s[0] = 1;
        s[n + 1] = 2;
        int cur = 1;
        long ans = 0;
        for (int i = 2; i <= n; ++i) {
            int pos = (cur << 1) - i;
            int now = Math.max(Math.min(len[pos], cur + len[cur] - i), 0);
            while (s[i - now - 1] == s[i + now + 1])
                ++now;
            if (i + now > cur + len[cur])
                cur = i;
            ans += (now % 2 == 0) ? now / 2 : (now / 2 + 1);
            len[i] = now;
        }
        return ans;
    }
}
