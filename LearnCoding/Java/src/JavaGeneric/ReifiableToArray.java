package JavaGeneric;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ReifiableToArray {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3);
        String[] str = new String[]{"aaa"};
        Integer[] result = new Integer[]{0, 1, 2, 3, 5};
//        a.toArray(str);
        Integer[] integers = a.toArray(result);

        System.out.println(integers[0]);

        Integer[] ints = new Integer[]{1};
        Number[] nums = ints;
        nums[0] = 1.01; // array store exception int n = ints[0];
    }
}

class Right {
    public static <T> T[] toArray(Collection<T> c, T[] a) {
        if (a.length < c.size())
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), c.size());// unchecked cast
        int i = 0;
        for (T x : c) a[i++] = x;
        if (i < a.length) a[i] = null;
        return a;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two");
        String[] a = toArray(strings, new String[0]);
        assert Arrays.toString(a).equals("[one, two]");
        String[] b = new String[]{"x", "x", "x", "x"};
        toArray(strings, b);
        assert Arrays.toString(b).equals("[one, two, null, x]");
    }
}