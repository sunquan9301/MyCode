package MaxRedRect;

import java.util.Scanner;
import java.util.Stack;

public class Main {
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
        int[][] height = new int[row][column];
        calculateHeight(stack, matrix, height);
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        for (int i = 0; i < row; i++) {
//            System.out.println(Arrays.toString(height[i]));
//        }

        int max = 0;
        for (int i = 0; i < column; i++) max = Math.max(max, maxMatrix(stack, height, i));
        System.out.println(max);
    }

    public static int maxMatrix(Stack<Integer> stack, int[][] arr, int col) {
        stack.clear();
        int maxResult = 0;
        int i = 0;
        while (i < arr.length) {
            if (stack.isEmpty() || arr[stack.peek()][col] <= arr[i][col]) {
                stack.push(i);
                i++;
            } else {
                int hi = arr[stack.pop()][col];
//                System.out.println("hi = " + hi + ";right = " + i + ";left = " + (stack.isEmpty() ? -1 : stack.peek()) + ";rect = " + ((i - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
                maxResult = Math.max(maxResult, ((i - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
            }
        }
        while (!stack.isEmpty()) {
            int hi = arr[stack.pop()][col];
//            System.out.println("hi = "+hi+";right = "+arr.length+";left = "+(stack.isEmpty() ? -1 : stack.peek())+";rect = "+((arr.length - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
            maxResult = Math.max(maxResult, ((arr.length - (stack.isEmpty() ? -1 : stack.peek()) - 1) * hi));
        }
        return maxResult;
    }

    public static void calculateHeight(Stack<Integer> stack, boolean[][] data, int[][] height) {
        for (int i = 0; i < data.length; i++) {
            calculateHeightForEachRow(stack, data[i], height[i]);
        }
    }

    public static void calculateHeightForEachRow(Stack<Integer> stack, boolean[] data, int[] height) {
        for (int i = 0; i < data.length; i++) {
            if (!data[i]) {
                height[i] = 0;
                while (!stack.isEmpty()) height[stack.peek()] = i - stack.pop();
            } else {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) height[stack.peek()] = data.length - stack.pop();
    }
}
