package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input length should be not null and positive");
        }

        if (nums.length <= 2) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int midLength = nums.length / 2;

        for (int num : nums) {
            int numCount = map.getOrDefault(num, 0) + 1;

            if (numCount > midLength) {
                return num;
            }

            map.put(num, numCount);
        }

        throw new IllegalArgumentException("Input have a majority element");
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
}
