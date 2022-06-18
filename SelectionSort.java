import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 10, 3, 15, 1, 32, 6, 48));
        System.out.println(sort(nums));
    }

    private static List<Integer> sort(List<Integer> nums) {
        ArrayList<Integer> sorted = new ArrayList<>();
        while (nums.size() > 0) {
            sorted.add(findMin(nums));
        }
        return sorted;
    }

    private static Integer findMin(List<Integer> nums) {
        int min = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(min)) {
                min = i;
            }
        }
        return nums.remove(min);
    }
}