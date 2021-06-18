package basic;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> opts = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String next = cin.next();
            System.out.println(next);
            if (next.equals("(")) ;
            else if (next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/")) opts.push(next);
            else if (next.equals(")")) {
                String opt = opts.pop();
                double result = vals.pop();
                if (opt.equals("+")) result += vals.pop();
                else if (opt.equals("-")) result -= vals.pop();
                else if (opt.equals("*")) result *= vals.pop();
                else if (opt.equals("/")) result /= vals.pop();
                vals.push(result);

            } else vals.push(Double.parseDouble(next));
        }
        System.out.println(vals.pop());
    }
}
