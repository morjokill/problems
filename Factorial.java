import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int n = 20;
        BigInteger factorial = factorial(n);
        System.out.println(factorial);
    }

    public static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        BigInteger fac = BigInteger.valueOf(2);
        for (int i = 3; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }
}