package Sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
        System.out.println("===============before============");
        System.out.println(Arrays.toString(a));
        s.quickSort(a);
        System.out.println("===============after============");
        System.out.println(Arrays.toString(a));

    }

    //小数据 5-15 用插入排序更好

    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int left, int right) {
        if (right <= left) return;
        int mid = partion(a, left, right);
        quickSort(a, left, mid - 1);
        quickSort(a, mid + 1, right);
//
//        if(right<=left) return;
//        int mid = partion(a,left,right);
//        quickSort(a,left,mid);
//        quickSort(a,mid+1,right);
//
    }


    public int partion(int[] a, int left, int right) {
        int start = left + 1;
        int end = right;
        while (start < end) {
            if (a[start] <= a[left]) {
                start++;
                continue;
            } else if (a[end] > a[left]) {
                end--;
                continue;
            }
            int temp = a[start];a[start] = a[end];a[end] = temp;
            start++;
            end--;
        }
        if (a[start] <= a[left]) {
            int temp = a[start];
            a[start] = a[left];
            a[left] = temp;
            return start;
        } else {
            int temp = a[start - 1];
            a[start - 1] = a[left];
            a[left] = temp;
            return start - 1;
        }
    }
}
