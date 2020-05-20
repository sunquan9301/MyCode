package Queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] queue = new String[100000];
        int head = 0;
        int tail = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int opt = in.nextInt();
            if (opt == 1) queue[++head] = in.next();
            else if (opt == 2) {
                System.out.println(queue[++tail]);
                queue[tail] = "";
            } else if (opt == 3) {
                System.out.println(queue[in.nextInt()+tail]);
            }
        }
    }
}
