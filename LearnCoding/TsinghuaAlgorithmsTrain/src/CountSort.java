import java.util.Arrays;

public class CountSort {

    private static int[] countSort(int[] a, int k) {
        int[] sum = new int[k + 1];//构造C数组
        int length = a.length;//获取A数组大小用于构造B数组
        int[] B = new int[length];//构造B数组

        for (int i = 0; i < length; i++) {
            sum[a[i]] += 1;// 统计A中各元素个数，存入C数组
        }
        for (int i = 1; i < k + 1; i++) {
            sum[i] += sum[i - 1];
        }
        for (int i = length - 1; i >= 0; i--)//遍历A数组，构造B数组
        {
            B[sum[a[i]] - 1] = a[i];//将A中该元素放到排序后数组B中指定的位置
            sum[a[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素
        }
        return B;//将排序好的数组返回，完成排序

    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = countSort(A, 5);
        System.out.println(Arrays.toString(B));
    }
}