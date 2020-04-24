package JavaGeneric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EffectiveGenericLegacyLibrary {
    public static void addItems(List list) {
        list.add(new Integer(1)); list.add("two"); }
    public static List getItems() {
        List list = new ArrayList();
        list.add(new Integer(3)); list.add("four"); return list;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        EffectiveGenericLegacyLibrary.addItems(list);
        List<Integer> list2 = EffectiveGenericLegacyLibrary.getItems(); // unchecked // sometime later ...
        int s = 0;
        for (int i : list) s += i; // class cast exception
        for (int i : list2) s += i; // class cast exception
    }
}
