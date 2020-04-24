package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class ListReverseError {

    public static void main(String[] args) {

    }

    public static void reverse(List<?> list) {
//        List<Object> tmp = new ArrayList<Object>(list);
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, tmp.get(list.size() - i - 1)); // compile-time error }
//        }
    }
}

