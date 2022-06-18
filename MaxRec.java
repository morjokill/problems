import java.util.*;

public class MaxRec {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 10, 124, 22, 200};
        System.out.println(max(nums));
    }

    private static int max(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(nums[0], max(Arrays.copyOfRange(nums, 1, nums.length)));
    }
}