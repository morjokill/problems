public class CountRec {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 1, 2, 5, 2, 1, 0};
        System.out.println(count(nums));
    }

    private static int count(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] nums1 = new int[nums.length - 1];
        System.arraycopy(nums, 1, nums1, 0, nums.length - 1);
        return count(nums1) + 1;
    }
}