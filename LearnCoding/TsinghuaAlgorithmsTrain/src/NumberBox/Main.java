package NumberBox;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int opt = in.nextInt();
            String str = in.next();
            if (opt == 1) System.out.println(set.add(str) ? "Succeeded" : "Failed");
            else System.out.println(set.remove(str) ? "Succeeded" : "Failed");
        }
    }
}
