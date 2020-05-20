package Equator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int n = cin.nextInt();
            int m = cin.nextInt();

            int[] value = new int[n + 1];
            int[] size = new int[n + 1];
            int[][] constraints = new int[m][3];
            for (int k = 0; k < value.length; k++) {
                value[k] = k;
                size[k] = 1;
            }
            for (int j = 0; j < m; j++) {
                int first = cin.nextInt();
                int second = cin.nextInt();
                int isConn = cin.nextInt();
                constraints[j][0] = first;
                constraints[j][1] = second;
                constraints[j][2] = isConn;
                if (isConn == 1) union(value, size, first, second);
//                result = checkConstraint(value, size, cin.nextInt(), cin.nextInt(), cin.nextInt());
//                if (!result) break;
            }
            boolean result = true;
            for (int j = 0; j < m; j++) {
                if (constraints[j][2] == 1) continue;
                result = checkConstraint(value, constraints[j][0], constraints[j][1]);
                if (!result) break;
            }
            System.out.println(result ? "Yes" : "No");
        }
    }

    //检查不相等 0 unconnect
    private static boolean checkConstraint(int[] value, int p, int q) {
        int pRoot = find(value, p);
        int qRoot = find(value, q);
        return value[pRoot] != value[qRoot];
    }

    private static void union(int[] value, int[] size, int p, int q) {
        int rootP = find(value, p);
        int rootQ = find(value, q);
        if (rootP == rootQ) return;
        if (size[rootP] < size[rootQ]) {
            value[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            value[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    private static int find(int[] value, int p) {
        int temp = p;
        while (p != value[p]) {
            p = value[p];
        }
        while (temp != p) {
            int temp1 = value[temp];
            value[temp] = p;
            temp = temp1;
        }
        return p;
    }
}
