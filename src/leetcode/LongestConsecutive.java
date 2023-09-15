package leetcode;

import java.util.Arrays;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int longestConsecutiveLength = 1;
        int tmpLongestConsecutiveLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int subResult = nums[i + 1] - nums[i];

            if (subResult == 1) {
                tmpLongestConsecutiveLength++;

                if (longestConsecutiveLength < tmpLongestConsecutiveLength) {
                    longestConsecutiveLength = tmpLongestConsecutiveLength;
                }
            } else if (subResult != 0 && tmpLongestConsecutiveLength != 1) {
                tmpLongestConsecutiveLength = 1;
            }
        }

        return longestConsecutiveLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
