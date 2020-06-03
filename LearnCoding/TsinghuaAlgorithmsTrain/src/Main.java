import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int a1 = cin.nextInt();
        int p = cin.nextInt();
        int q = cin.nextInt();
        int M = cin.nextInt();
        long[] value = new long[n + 1];
        value[1] = a1;
        for (int i = 2; i <= n; i++) value[i] = (p * value[i - 1] + q) % M;
        System.out.println(BFPRT(value, 1, n, k));
    }

    public static long BFPRT(long a[], int l, int r, int id) {
        if (r - l + 1 <= 5) {
            insertSort(a, l, r);
            return a[l + id - 1];
        }
        int t = l - 1;
        for (int st = l, ed; (ed = st + 4) <= r; st += 5) {
            insertSort(a, st, ed);
            t++;
            swap(a, t, st + 2);
        }
        int pivotId = (l + t) >> 1;
        BFPRT(a, l, t, pivotId - l + 1);
        int m = partition(a, l, r, pivotId), cur = m - l + 1;
        if (id == cur) return a[m];
        else if (id < cur) return BFPRT(a, l, m - 1, id);
        else return BFPRT(a, m + 1, r, id - cur);
    }


    public static int partition(long[] a, int l, int r, int pivotId) {
        swap(a, pivotId, r);
        int j = l - 1;
        for (int i = l; i < r; i++) {
            if (a[i] <= a[r]) {
                j++;
                swap(a, j, i);
            }
        }
        ++j;
        swap(a, j, r);
        return j;
    }

    public static long calMidValue(long[] value, int lo, int hi) {
        if (hi - lo + 1 <= 5) {
            insertSort(value, lo, hi);
            int mid = (lo + hi) / 2;
            return value[mid];
        }
        int t = lo - 1;
        for (int i = lo; i <= hi - 4; i = i + 5) {
            insertSort(value, i, i + 4);
            t++;
            swap(value, t, i + 2);
        }
        return (lo + t) >> 1;
    }

    public static void insertSort(long[] value, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && value[j] < value[j - 1]; j--) {
                swap(value, j, j - 1);
            }
        }
    }

    public static void swap(long[] value, int p, int q) {
        long temp = value[p];
        value[p] = value[q];
        value[q] = temp;
    }

}
