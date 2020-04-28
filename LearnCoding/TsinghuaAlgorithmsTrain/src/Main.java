import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        maxMatrix(arr);
    }

    public static void maxMatrix(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxResult = 0;
        int i = 0;
        while (i < arr.length) {
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i);
                i++;
            } else {
                int hi = arr[stack.pop()];
//                System.out.println("hi = " + hi + ";right = " + i + ";left = " + (stack.isEmpty() ? -1 : stack.peek()) + ";rect = " + ((i - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
                maxResult = Math.max(maxResult, ((i - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
            }
        }
        while (!stack.isEmpty()) {
            int hi = arr[stack.pop()];
//            System.out.println("hi = "+hi+";right = "+arr.length+";left = "+(stack.isEmpty() ? -1 : stack.peek())+";rect = "+((arr.length - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
            maxResult = Math.max(maxResult, ((arr.length - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
        }
        System.out.println(maxResult);
    }
}
