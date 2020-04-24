package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class ReflectionForPrimitive {
    public static void main(String[] args) {
        //actually it is int; but int is not referent type so Class<int> --> Class<Integer>
        Class<Integer> integerClass = int.class;
        //it will throw cast exception
        int.class.cast(0);
        //false
        System.out.println(integerClass == Integer.class);
        //true
        System.out.println(Integer.TYPE == integerClass);
        //return int[]
        java.lang.reflect.Array.newInstance(int.class, 2);
    }
}
