package javabasic;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args){
        HashSet<Integer> aa= new HashSet<Integer>();
        HashSet<Integer> bb= new HashSet<Integer>();
        aa.add(1);
        aa.add(2);
        for(Integer integer:aa){
            bb.add(integer);
        }
        System.out.println(aa.equals(bb));
    }
}
