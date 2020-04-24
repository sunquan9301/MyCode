package arrays;

public class L189ArrayRotation {
    public static void main(String[] args) {

        rotate(new int[]{1, 2, 3}, 2);
    }
/*

 */

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] tempValue = new int[k];
        int count = 0;
        for (int i = nums.length - 1; i >= k; i--) {
            if (i >= nums.length - k) {
                tempValue[count++] = nums[i];
            }
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempValue[k - i - 1];
        }
    }

    public static void transRight(int[] nums, int k, int left, int times) {
        int count = 0;
        int start = left;
        int target = (start + k) % nums.length;
        int tempValue = nums[start];
        int temp;
        while (count < times) {
            temp = nums[target];
            nums[target] = tempValue;
            tempValue = temp;
            start = target;
            target = (start + k) % nums.length;
            count++;
        }
    }
}
