package Sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        s.mergeSort(new int[]{62, 56, 78, 48, 70, 52, 64, 57});
//        int[] a = new int[1000];
//        for(int i=0;i<a.length;i++){
//            a[i] = (int) (Math.random()*1000);
//        }
//        System.out.println("===============before============");
//        System.out.println(Arrays.toString(a));
//        s.mergeSort2(a);
//        System.out.println("===============after============");
//        System.out.println(Arrays.toString(a));

    }

    //自顶向下
    public void mergeSort(int[] a) {
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
    }


    //自低向上
    public void mergeSort2(int[] a) {
        int[] temp = new int[a.length];
        int gap = 1, N = a.length;
        for (gap = 1; gap < N; gap += gap) {
            for (int i = 0; i < N - gap; i = i + 2 * gap) {
                merge(a, i, i + gap - 1, Math.min(i + 2 * gap - 1, a.length - 1), temp);
            }
        }
    }


    public void mergeSort(int[] a, int start, int end, int[] temp) {
        if (start >= end - 1) return;
        int middle = start + (end - start) / 2;
        mergeSort(a, start, middle, temp);
        mergeSort(a, middle + 1, end, temp);
        merge(a, start, middle, end, temp);
        System.out.println(Arrays.toString(a));
    }

    public void merge(int[] a, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++)
            temp[i] = a[i];
        int p = left, q = mid + 1;
        for (int i = left; i <= right; i++) {
            if (p > mid) a[i] = temp[q++];
            else if (q > right) a[i] = temp[p++];
            else if (temp[p] > temp[q]) a[i] = temp[q++];
            else a[i] = temp[p++];
        }
    }

    public void merge3(int[] a, int left, int middle, int right, int[] temp) {
        for (int i = left; i <= right; i++)
            temp[i] = a[i];
        int p = left, q = middle + 1;
        for (int i = left; i <= right; i++) {
            if (p > middle) a[i] = temp[q++];
            else if (q > right) a[i] = temp[p++];
            else if (temp[p] > temp[q]) a[i] = temp[q++];
            else a[i] = temp[p++];
        }
    }


    public void mergeSortDemo(int[] aar, int left, int right, int[] temp) {
        if (left > right) return;
        int mid = left + (right - left) / 2;
        mergeSortDemo(aar, left, mid, temp);
        mergeSortDemo(aar, mid + 1, right, temp);
        mergeDemo(aar, left, mid, right, temp);
        int gap = 1;
        int N = aar.length;
        for (gap = 1; gap < N; gap += gap) {
            for(int j = 0;j<N-gap;j+=gap+gap){
                mergeDemo(aar,j,j+gap-1,Math.min(j+2*gap-1,N),temp);
            }
        }
    }

    public void mergeDemo(int[] arr, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int p = left, q = mid + 1;
        for (int i = left; i <= right; i++) {
            if (p > mid) arr[i] = temp[q++];
            else if (q > right) arr[i] = temp[p++];
            else if (temp[p] > temp[q]) arr[i] = temp[q++];
            else arr[i] = temp[p++];
        }
    }
}
