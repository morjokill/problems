import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 10, 3, 15, 1, 32, 6, 48, 200, 1243, 16, 333};
        System.out.println(Arrays.toString(sort(nums)));
    }

    private static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int pivot = pivot(nums);
        // swap
        swap(nums, 0, pivot);
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] < nums[0]) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, 0, i - 1);

        int[] leftArray = sort(Arrays.copyOfRange(nums, 0, i - 1));
        int[] rightArray = sort(Arrays.copyOfRange(nums, i, nums.length));

        return concatenate(leftArray, rightArray, nums[i - 1]);
    }

    private static int pivot(int[] nums) {
        Random rand = new Random();
        return rand.nextInt(nums.length);
    }

    private static void swap(int[] nums, int first, int second) {
        int cup = nums[first];
        nums[first] = nums[second];
        nums[second] = cup;
    }

    private static int[] concatenate(int[] left, int[] right, int middle) {
        int[] result = new int[left.length + right.length + 1];
        System.arraycopy(left, 0, result, 0, left.length);
        result[left.length] = middle;
        System.arraycopy(right, 0, result, left.length + 1, right.length);
        return result;
    }
}