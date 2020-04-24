package Sort;

import jdk.nashorn.tools.Shell;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args){
        ShellSort s = new ShellSort();
        int[] a = new int[100];
        for(int i=0;i<a.length;i++){
            a[i] = (int) (Math.random()*1000);
        }
        System.out.println("===============before============");
        System.out.println(Arrays.toString(a));
        s.shellSort(a);
        System.out.println("===============after============");
        System.out.println(Arrays.toString(a));

    }

    public void shellSort(int[] a){
        int N = a.length;
        int h =1;
        while(h<N/3) h = 3*h+1;
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&a[j]<a[j-h];j = j-h){
                    int temp = a[j];a[j] = a[j-h];a[j-h] = temp;
                }
            }
            h = h/3;
        }

    }

}
