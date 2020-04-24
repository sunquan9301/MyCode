package JavaGeneric;

import java.util.*;

/**
 * @author sunquan
 * sunquan@bitstarlight.com
 * @date 2020/2/24
 **/
public class Demo {
    public static void main(String[] args) {
        Demo m = new Demo();
//        System.out.print(m.freqAlphabets("10#11#12"));
//        ArrayList<String> s = new ArrayList<>();
//        System.out.print(Integer.toHexString(Integer.valueOf("31")).toUpperCase());
//        m.highFive(new int[][]{{1, 2}, {1, 3}, {2, 2}, {2, 3}});

    }

    public String freqAlphabets(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                int val = Integer.valueOf(s.substring(i - 2, i));
                result = (char) ('a' + val - 1) + result;
                i = i - 2;
            } else {
                result = (char) ('a' + Integer.parseInt(s.charAt(i) + "") - 1) + result;
            }
        }
        return result;
    }

}
