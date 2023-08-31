package leetcode;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,3,3,5,6,4}; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = new int[]{1,3,3,3,4,5,6}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        Arrays.sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
