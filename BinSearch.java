import java.util.Arrays;

public class BinSearch {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 10, 17, 30, 31, 37, 46, 121, 200, 315};
        System.out.println(search(nums, 200));
    }

    private static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int half = nums.length / 2;
        int middle = nums[half];
        if (middle == target) {
            return true;
        } else if (middle > target) {
            return search(Arrays.copyOfRange(nums, 0, half), target);
        } else {
            return search(Arrays.copyOfRange(nums, half + 1, nums.length), target);
        }
    }
}