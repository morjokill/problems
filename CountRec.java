import java.util.*;

public class CountRec {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 1, 2, 5, 2, 1, 0};
        System.out.println(count(nums));
    }

    private static int count(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return 1 + count(Arrays.copyOfRange(nums, 0, nums.length - 1));
    }
}