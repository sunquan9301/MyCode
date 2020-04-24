package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    public static void main(String[] args){
        List<Integer> integers = Lists1.toList(1, 2, 3);
        Lists1.<Integer>toList(1,2,3);
    }
}

class Lists1 {
    static {
    }
    public static <T> List<T> toList(T... arr) {
        List<T> list = new ArrayList<T>();
        for (T elt : arr) list.add(elt);
        return list;
    }
}