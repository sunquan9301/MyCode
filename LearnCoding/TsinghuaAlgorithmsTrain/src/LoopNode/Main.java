package LoopNode;

import java.util.Scanner;

public class Main {
    static int N = 1000000 + 10;
    static int[] next = new int[N];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
        String s = cin.next();
//        buildNext(s);
//        int i = 0;
//        for (i = 1; i < n; i++) {
//            if (i % (i - next[i]) == 0 && next[i] != 0) {
//                break;
//            }
//        }
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
                if (i % (i - next[i]) == 0 && next[i] != 0) {
                    break;
                }
            } else
                j = next[j];
        }
        System.out.println(i - next[i]);
    }

//
//    int solve(char[] s, int len) {
//        for(int i=0,j=1;j<len;){
//            while(s[i]!=s[j]){
//                j++;
//            }
//            int ans = j-i;
//            while(s[i] == s[j]){
//                i++;j++;
//            }
//            if(j>=s.length){
//                return ans;
//            }
//            else{
//                i=0;
//            }
//        }
//    }

    public static void buildNext(String p) {

        int i = 0, j = -1;
        next[0] = -1;
        while (i < p.length()) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
    }
}
