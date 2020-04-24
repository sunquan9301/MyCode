package arrays;

import java.util.*;

import static sun.tools.jstat.Alignment.keySet;

public class TwoSum {

    private enum Color {
        RED, ORANGE, YELLO, GREEN

    }

    public static void main(String[] args) {
//        LinkedHashSet set = new LinkedHashSet(6);
//        HashMap<Integer, Integer> map = new HashMap<>(8);
//        map.put(1, 1);
//        map.put(3, 1);
//        map.put(2, 1);
//        map.put(4, 3);
//        map.put(8, 4);
//        map.put(6, 5);
//        EnumSet<Color> es = EnumSet.of(Color.RED, Color.ORANGE);
//        for (Color a : es) {
//            System.out.println(a);
//        }

//        Integer a = null;
//        Integer b = 1;
//        System.out.println(b.compareTo(a));

    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> valueMapIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!valueMapIndex.containsKey(target - numbers[i])) {
                valueMapIndex.put(numbers[i], i);
                continue;
            }

            return new int[]{valueMapIndex.get(target - numbers[i]) + 1, i + 1};
        }
        return new int[]{0, 0};
    }

    public static int thirdMax(int[] nums) {
        int first = nums[0];
        int second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == first || nums[i] == second || nums[i] == third) continue;
            if (nums[i] > first) {
                first = nums[i];
                second = first;
                third = second;
            } else if (nums[i] > second) {
                second = nums[i];
                third = second;
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        if (third != Integer.MIN_VALUE) return third;
        return first;

    }
}
