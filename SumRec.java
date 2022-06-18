import java.util.*;

public class SumRec {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 6, 10, 1};
        System.out.println(sum(nums));
    }

    private static int sum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return nums[0] + sum(Arrays.copyOfRange(nums, 1, nums.length));
    }
}