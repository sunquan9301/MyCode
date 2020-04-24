package assign;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println(log(32));
        System.out.println(log(48));
    }


    public static int log(int N) {
        if (N == 1) return 0;
        return 1 + log(N / 2);
    }
}
