package StackSort;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> right = new Stack<>();
        for (int i = 0; i < n; i++) {
            right.push(in.nextInt());
        }
        stackSort(right);
    }

    public static void stackSort(Stack<Integer> right) {
        if (right.isEmpty()) return;
        Stack<Integer> left = new Stack<>();
        while (!right.isEmpty()) {
            if (left.isEmpty() || left.peek() >= right.peek()) {
                left.push(right.pop());
            } else {
                int top = right.pop();
                while (!left.isEmpty() && left.peek() < top) {
                    right.push(left.pop());
                }
                left.push(top);
            }
        }
        while (!left.isEmpty()) {
            System.out.println(left.pop());
        }
    }
}
