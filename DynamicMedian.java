import java.util.*;

public class DynamicMedian {
    public static void median(int[] numbers) {
        Queue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> upper = new PriorityQueue<>();

        for (int number : numbers) {
            //insert
            if (lower.isEmpty() || number <= lower.peek()) {
                lower.offer(number);
            } else {
                upper.offer(number);
            }

            //balance
            if (lower.size() - upper.size() > 1) {
                upper.offer(lower.poll());
            } else if (upper.size() - lower.size() > 1) {
                lower.offer(upper.poll());
            }

            String median = "";
            //print median
            if (lower.size() > upper.size()) {
                median = lower.peek() + "";
            } else if (upper.size() > lower.size()) {
                median = upper.peek() + "";
            } else {
                median = lower.peek() + " " + upper.peek() + "";
            }
            System.out.println("Median : " + median + " Heaps {" + lower + " --- " + upper + "}");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 2, 23, 13, 7, 3, 4, 17, 41, 25, 8, 11, 22};
        median(numbers);
        Arrays.sort(numbers);
        System.out.println("Length : " + numbers.length);
        System.out.println("Sorted : " + Arrays.toString(numbers));
    }
}