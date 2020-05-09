package Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] stack = new String[100000];
        int top = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int opt = in.nextInt();
            if (opt == 1) stack[++top] = in.next();
            else if (opt == 2) {
                System.out.println(stack[top]);
                stack[top--] = "";
            }else if(opt == 3){
                System.out.println(stack[in.nextInt()]);
            }
        }
    }
}
