package PaperCard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] mark = new int[2 * n + 1];
        for (int i = 0; i < n; i++) mark[cin.nextInt()] = 1;
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        int c1 = 1, c2 = 1;
        for (int i = 1; i <= 2 * n; i++)
            if (mark[i] == 1) B[c2++] = i;
            else A[c1++] = i;
        int result = 0;
        int i = 1, j = 1;
        while (i <= n && j <= n)
            if (B[j] < A[i]) {
                j++;
                i++;
                result++;
            } else i++;
        System.out.println(result);
    }
}
