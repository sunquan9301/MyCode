import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println(getAnswer(n));
    }

    public static int twoPow(int x) {
        return 1 << x;
    }

    public static String getAnswer(int n) {
        int allOne = twoPow(n - 1) - 1;
        StringBuilder ans = new StringBuilder();
        List<Boolean>[] vis = new ArrayList[2];
        for (int i = 0; i < 2; ++i) {
            vis[i] = new ArrayList<>(Collections.nCopies(twoPow(n - 1), false));
        }
        dfs(0, ans, vis, allOne);
        return ans.toString();
    }

    private static void dfs(int u, StringBuilder ans, List<Boolean>[] vis, int allOne) {
        for (int i = 0; i < 2; ++i) {
            if (!vis[i].get(u)) {
                int v = ((u << 1) | i) & allOne;
                vis[i].set(u, true);
                dfs(v, ans, vis, allOne);
                ans.append(i);
            }
        }
    }
}
