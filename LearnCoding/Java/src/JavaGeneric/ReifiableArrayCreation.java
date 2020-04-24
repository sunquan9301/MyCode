package JavaGeneric;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReifiableArrayCreation {
    public static void main(String[] args) {
//        Integer[] ints = new Integer[]{1, 2, 3};
//        Number[] nums = ints;
//        nums[2] = 3.14;

        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        List<List<Integer>> c = Arrays.asList(a, b);
    }

    public static <T> void create(T[] a) {

    }
}
