package Fundamentals;

import java.util.Stack;

public class StackNullElement {

    /**
     * 是否允许向栈中添加空元素
     */

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(null);
        s.push(null);
        System.out.println(s.toString());

    }
}
