package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            nums1 = new int[m+n];
        }

        for (int i = m + n - 1; i >= 0 && m >= 0 ; i--) {
            if (m == 0 || (n > 0 && nums2[n-1] > nums1[m-1])) {
                nums1[i] = nums2[--n];
            } else {
                nums1[i] = nums1[--m];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge2(int[] nums1, int m, int[] nums2) {
        nums1 = IntStream
                .concat(Arrays.stream(Arrays.copyOfRange(nums1, 0, m)),
                        Arrays.stream(nums2))
                .sorted()
                .toArray();

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        merge(new int[]{}, 0, new int[]{1}, 1);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);

        merge2(new int[]{}, 0, new int[]{1});
        merge2(new int[]{1}, 1, new int[]{});
        merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6});
    }
}
