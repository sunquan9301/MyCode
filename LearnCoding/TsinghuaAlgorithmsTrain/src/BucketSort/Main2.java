package BucketSort;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int seed = cin.nextInt();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31) - 1);
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) {
            seed = nextInt(seed);
            a[i] = intToUnsignedInt(seed) >> (32 - k);
        }
        long max = a[0], min = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        long bucketSize = Math.max(1, (max - min) / (n - 1));
        long bucketNum = ((max - min) / bucketSize + 1);
        BucketBean[] buckets = new BucketBean[(int) bucketNum];
        for (int i = 0; i < n; ++i) {
            int index = (int) ((a[i] - min) / bucketSize);
            buckets[index] = new BucketBean();
            buckets[index].max = Math.max(buckets[index].max, a[i]);
            buckets[index].min = Math.min(buckets[index].min, a[i]);
        }
        long maxGap = 0;
        int last = 0;
        for (int i = 1; i < n; ++i) {
            if (buckets[i] == null) continue;
            long temp = buckets[i].min - buckets[last].max;
            maxGap = Math.max(maxGap, temp);
            last = i;
        }

        System.out.println(maxGap);
    }

    static class BucketBean {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
    }

    static int nextInt(int seed) {
        seed ^= seed << 13;
        seed ^= seed >> 17;
        seed ^= seed << 5;
        return seed;
    }

    static long intToUnsignedInt(int x) {
        if (x >= 0)
            return x;
        return (long) x + (1L << 32);
    }

}
