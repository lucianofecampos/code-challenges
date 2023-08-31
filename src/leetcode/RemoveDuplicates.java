package leetcode;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,2,2,4,5,6}; // Input array
        int[] expectedNums = new int[]{1,2,4,5,6}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
