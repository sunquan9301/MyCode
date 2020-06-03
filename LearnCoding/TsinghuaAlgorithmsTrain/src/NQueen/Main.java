package NQueen;

import java.util.Scanner;

public class Main {
    static int ans;
    static int allOne;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        ans = 0;
        allOne = (1 << n) - 1;
        dfs(0, 0, 0);
        System.out.println(ans);
    }

//    static void dfs(int row, int ld, int rd)
//    {
//        if(row != allOne)
//        {
//            int pos = allOne & ~(row | ld | rd);
//            while(pos!=0)
//            {
//                int p = pos & -pos;
//                pos -= p;
//                dfs(row + p, (ld + p) << 1, (rd + p) >> 1);
//            }
//        }
//        else
//            ans++;
//    }
    public static void dfs(int pos, int left, int right) {
        if (pos == allOne) {
            ++ans;
            return;
        }
        for (int t = allOne & (~(pos | left | right)); t != 0; ) {
            int p = t & -t;
            dfs(pos | p, (left | p) << 1, (right | p) >> 1);
            t ^= p;
        }

    }
}
