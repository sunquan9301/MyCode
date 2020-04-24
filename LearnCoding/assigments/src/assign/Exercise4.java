package assign;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println(pentagonal(1));
        System.out.println(pentagonal(2));
        System.out.println(pentagonal(3));
        System.out.println(pentagonal(4));
    }

    /**
     * p1 = 1
     * p2 = 5  (p2 - p1) = 4
     * p3 = 12 (p3 - p2) = 7
     * p4 = 22 (p4 - p3) = 10
     * => p(n)-p(n-1) = 3(n-1)+1
     * => p(n) = p(n-1)+3n-2;
     * @param N
     * @return
     */
    public static int pentagonal(int N) {
        if (N == 1) return 1;
        return 3 * N - 2 + pentagonal(N - 1);
    }
}
