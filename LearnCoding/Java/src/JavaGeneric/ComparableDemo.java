package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        String s = "adfja";
        assert s.equals(null);
        String s1 = null;
        assert s.equals(null);

//        System.out.println(s.compareTo(null)>0);
//        System.out.println(s instanceof Object);


    }

    public static int allZero(List<Integer> ints) {
        return ints.size();
    }
}
