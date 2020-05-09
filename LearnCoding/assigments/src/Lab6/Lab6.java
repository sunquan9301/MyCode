package Lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab6 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>(25);
        System.out.println("Enter some numbers (Ctrl-d to quit):");
        while (true) {
            try {
                if (input.hasNext()) {
                    if (input.hasNextInt()) {
                        int n = input.nextInt();
                        arr.add(n);
                    } else {
                        System.out.println("please input correct num(Ctrl-d to quit):");
                        input.next();
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("please input correct num(Ctrl-d to quit):");
                e.printStackTrace();
            }
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
