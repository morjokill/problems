import java.lang.*;

public class MaxRec {
	public static void main(String[] args) {
		int[] nums = new int[]{5, 10, 124, 22, 200};
		System.out.println(max(nums));
	}

	private static int max(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int[] nums1 = new int[nums.length - 1];
		System.arraycopy(nums, 1, nums1, 0, nums.length - 1);
		return Math.max(nums[0], max(nums1));
	}
}