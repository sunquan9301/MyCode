package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

public class WildcardsRestriction {

    public static void main(String[] args){
        //List<?> list = new ArrayList<?>(); //it's ok
        List<?> list2 = new ArrayList<Object>(); //for top reference object ; it's ok
        List<List<?>> list1 = new ArrayList<List<?>>(); // it is not ok
    }
}
