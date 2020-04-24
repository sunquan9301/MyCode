package javabasic;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class A {
    public static void main(String args[]) {
        for (int i=0;i<10;i++){
            System.out.println("index = "+i);
            System.out.println(calc(i));
        }
    }


    public static int methodA(int k) {
        int total = 0;
        while (k < 7) {
            total += (k * 4) % 7;
            k++;
        }
        return total;
    }

    public static int calc(int m) {
        int k = -1;
        int b = -1;
        while (b < m) {
            k = k + 3;
            b++;
        }
        return k;
    }

    public static void test(int m) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(m, 33);
        System.out.println(list.get(3) - list.get(2));
    }

    public static int methodB(int k) {
        int total = 1;
        int[] a = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < a.length - k; i++) {
            if (a[i] % 3 == 0) {
                total += a[i];
                a[i] *= 3;
            }
        }
        return total;
    }

}

class Student {
    public String name;

    public Student(String name) {
        this.name = name;
    }
}
