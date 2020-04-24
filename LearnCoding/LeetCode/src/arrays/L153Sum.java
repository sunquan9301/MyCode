package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L153Sum {
    static int count = 0;
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        findPair(0, nums.length - 1, nums, result);
        return result;
    }

    public static void findPair(int left, int right, int[] nums, List<List<Integer>> result) {
        while (left < right - 1) {
            if(count<10) {
                System.out.println("<" + left + "," + right + ">");
                count++;
            }
            int value = nums[left] + nums[right];
            if (-value < nums[0]) {
                right = findNextRight(right, nums);
            } else if (-value > nums[nums.length - 1]) {
                left = findNextLeft(left, nums);
            } else {
                if (indexOfValue(0, left - 1, nums, -value)
                        || indexOfValue(right + 1, nums.length - 1, nums, -value)
                        || indexOfValue(left + 1, right - 1, nums, -value)) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[left]);
                    list.add(-value);
                    list.add(nums[right]);
                    result.add(list);
                }
                findPair(left, right - 1, nums, result);
                findPair(left + 1, right, nums, result);
                break;
            }
        }
    }

    public static int findNextLeft(int left, int[] nums) {
        int tempL = nums[left];
        left++;
        while (nums[left] == tempL) {
            left++;
        }
        return left;
    }

    public static int findNextRight(int right, int[] nums) {
        int tempR = nums[right];
        right--;
        while (nums[right] == tempR) {
            right--;
        }
        return right;
    }

    public static boolean indexOfValue(int start, int end, int[] nums, int value) {
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (value == nums[middle]) return true;
            if (value > nums[middle]) start = middle + 1;
            if (value < nums[middle]) end = middle - 1;
        }
        return false;
    }
}
