package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class WildcardsGenericMethodCallRestriction {

    public static void main(String[] args) {
        List<?> list = Lists.factory();
        List<?> list1 = Lists.<Object>factory();

//        List<?> list2 = Lists.<?>factory(); //compile-time error
        List<List<?>> list3 = Lists.<List<?>>factory(); // it's ok
        


    }

}

class Lists {
    public static <T> List<T> factory() {
        return new ArrayList<T>();
    }
}



