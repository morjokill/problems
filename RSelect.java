import java.util.*;

public class RSelect {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 10, 2, 3, 1, 8, 15};
        System.out.println(findMin(nums, 3));
    }

    private static int findMin(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int pivot = pivot(nums.length);
        int index = rotateOnPivot(nums, pivot);

        if (index == k) {
            return nums[k];
        } else if (index > k) {
            return findMin(Arrays.copyOfRange(nums, 0, index), k);
        } else {
            return findMin(Arrays.copyOfRange(nums, index + 1, nums.length), k - index - 1);
        }
    }

    private static int rotateOnPivot(int[] nums, int pivot) {
        swap(nums, 0, pivot);
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] < nums[0]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, 0, i - 1);
        return i - 1;
    }

    private static int pivot(int length) {
        Random rand = new Random();
        return rand.nextInt(length);
    }

    private static void swap(int[] nums, int first, int second) {
        int cup = nums[first];
        nums[first] = nums[second];
        nums[second] = cup;
    }
}