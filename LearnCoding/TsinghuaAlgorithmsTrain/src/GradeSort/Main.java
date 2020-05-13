package GradeSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int[] source = new int[20];
//        for(int i=0;i<source.length;i++){
//            source[i] = (int) (Math.random()*100);
//        }
//        System.out.println(Arrays.toString(source));
//        bubbleSort2(source);
//        System.out.println(Arrays.toString(source));
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Student[] stus = new Student[n];
        for (int i = 0; i < n; i++) stus[i] = new Student(i+1, cin.nextInt(), cin.nextInt());
        int count = 0;
        if (n < 20) {
            count = insertSort(stus);
        } else {
            count = bubbleSort3(stus);
        }
        for (int i = 0; i < stus.length; i++) System.out.println(stus[i].toString());
        System.out.println(count);
    }

    public static int insertSort(Student[] stus) {
        int count = 0, j;
        for (int i = 1; i < stus.length; i++) {
            j = i;
            while (j>0&&stus[j].compareTo(stus[j - 1]) > 0) {
                exch(stus, j, j - 1);
                count++;
                j--;
            }
        }
        return count;

    }

    public static void exch(Student[] stus, int i, int j) {
        Student s = stus[i];
        stus[i] = stus[j];
        stus[j] = s;
    }

    public static void exch1(int[] stus, int i, int j) {
        int s = stus[i];
        stus[i] = stus[j];
        stus[j] = s;
    }

    public static int bubbleSort(Student[] stus) {
        int count = 0;
        int n = stus.length;
        boolean isSorted = false;
        while (n > 0 && !isSorted) {
            isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (stus[i].compareTo(stus[i + 1]) < 0) {
                    exch(stus, i, i + 1);
                    count++;
                    isSorted = false;
                }
            }
            n--;
        }
        return count;
    }

    public static int bubbleSort3(Student[] stus) {
        int count = 0;
        int n = stus.length;
        int last = 0;
        while (n > 0) {
            last = 0;
            for (int i = 0; i < n - 1; i++) {
                if (stus[i].compareTo(stus[i + 1]) < 0) {
                    exch(stus, i, i + 1);
                    count++;
                    last = i+1;
                }
            }
            n=last;
        }
        return count;
    }

    public static int bubbleSort1(int[] stus) {
        int count = 0;
        int n = stus.length;
        boolean isSorted = false;
        while (n > 0 && !isSorted) {
            isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (stus[i] > stus[i + 1]) {
                    exch1(stus, i, i + 1);
                    count++;
                    isSorted = false;
                }
            }
            n--;
        }
        return count;
    }

    public static void bubbleSort2(int[] stus) {
        int n = stus.length;
        int last = 0;
        while (n > 0) {
            last = 0;
            for (int i = 0; i < n - 1; i++) {
                if (stus[i] > stus[i + 1]) {
                    exch1(stus, i, i + 1);
                    last = i+1;
                }
            }
            n = last;
        }
    }

}

class Student implements Comparable {
    private int algorithmScore;
    private int datastructureScore;
    private int allScore;
    private int id;

    public Student(int id, int algorithmScore, int datastructureScore) {
        this.algorithmScore = algorithmScore;
        this.datastructureScore = datastructureScore;
        this.allScore = this.algorithmScore + this.datastructureScore;
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        if (this.allScore < other.allScore) return -1;
        if (this.allScore > other.allScore) return 1;
        if (this.algorithmScore < other.algorithmScore) return -1;
        if (this.algorithmScore > other.algorithmScore) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return id + " " + allScore + " " + algorithmScore + " " + datastructureScore;
    }
}
