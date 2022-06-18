public class SumRec {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 5, 6, 10, 1};
		System.out.println(sum(nums));
	}

	private static int sum(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] nums1 = new int[nums.length - 1];
		System.arraycopy(nums, 1, nums1, 0, nums.length - 1);
		return nums[0] + sum(nums1);
	}
}