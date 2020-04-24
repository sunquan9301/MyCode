package assign;

import static assign.Exercise2.log;

public class Exercise3 {
    public static void main(String[] args) {
        System.out.println(pow(5));
        System.out.println(pow(log(32)));
    }


    public static int pow(int N) {
        if (N == 0) return 1;
        return 2 * pow(N - 1);
    }
}
