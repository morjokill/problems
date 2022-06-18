import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 10, 3, 15, 1, 32, 6, 48};
        System.out.println(Arrays.toString(sort(nums)));
    }

    private static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int[] leftArray = sort(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] rightArray = sort(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }

        return result;
    }
}