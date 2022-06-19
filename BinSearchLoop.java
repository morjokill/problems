public class BinSearchLoop {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 7, 10, 12, 39, 502, 1024};
        System.out.println(search(nums, 1024));
    }

    private static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int middle = (r + l) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }

        return -1;
    }
}