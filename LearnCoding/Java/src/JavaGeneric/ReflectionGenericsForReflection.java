package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class ReflectionGenericsForReflection {
    public static void main(String[] args) {
//        Class<Integer> ki = Integer.class;
//        Number n = new Integer(42);
//        Class<? extends Number> kn = n.getClass();
//        //can use ki ==  kn to compare
//        assert ki == kn;

        List<Integer> ints = new ArrayList<Integer>();
        Class<? extends List> k = ints.getClass();
        assert k == ArrayList.class;
    }
}
