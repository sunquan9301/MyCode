package assign;

public class additionQues {
    public static void main(String[] args) {
        System.out.println(triangle(3));
        System.out.println(triangle(4));
    }


    public static int triangle(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return 3 * triangle(N / 2) + triangle(N % 2 == 0 ? N / 2 - 1 : N / 2 + 1);
    }
}
