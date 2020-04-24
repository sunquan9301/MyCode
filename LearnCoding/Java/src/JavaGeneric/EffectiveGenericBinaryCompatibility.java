package JavaGeneric;

import java.util.Collection;

public class EffectiveGenericBinaryCompatibility {
    // legacy version
//    public static Object max(Collection coll) {
//        return null;
//    }
//
//    // generic version -- breaks binary compatibility
//    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll){
//        for(T value:coll){
//            return value;
//        };
//        return null;
//    }
//
//    // generic version -- maintains binary compatibility
//    public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll){
//        return null;
//    }

}
