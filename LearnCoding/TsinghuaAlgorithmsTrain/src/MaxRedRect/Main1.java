package MaxRedRect;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        boolean[][] matrix = new boolean[row][column];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < row; ++i) {
            String str = in.next().trim();
//            System.out.println(str);
            for (int j = 0; j < str.length(); ++j) {
                matrix[i][j] = str.charAt(j) == '.';
            }
        }

        int[] height = new int[column];
//        calculateHeight(stack, matrix, height);
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(height[i]));
//        }

        int max = 0;
        for (int i = 0; i < row; ++i) {
            for(int j=0;j<height.length;j++) height[j] = matrix[i][j]?height[j]+1:0;
            max = Math.max(max, maxMatrix(stack, height, i));
        }
        System.out.println(max);
    }

    public static int maxMatrix(Stack<Integer> stack, int[] arr, int row) {
        stack.clear();
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
        return maxResult;
    }

}
