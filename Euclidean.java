public class Euclidean {
    public static void main(String[] args) {
        int h = 1680;
        int w = 640;
        System.out.println(euclidean(h, w));
    }

    private static int euclidean(int h, int w) {
        int min = Math.min(h, w);
        int max = Math.max(h, w);
        if (max % min == 0) {
            return min;
        } else {
            return euclidean(max % min, min);
        }
    }
}