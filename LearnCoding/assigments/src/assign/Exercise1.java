package assign;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(square(3));
        System.out.println(square(4));
    }


    public static int square(int N) {
        if (N == 1) return 1;
        return 2 * N - 1 + square(N - 1);
    }
}
