package dpiqb;

public class Factorial {
    public long calc(long n){
        if (n < 0){
            throw new IllegalArgumentException("Input should be >= 0");
        }
        long result = 1;
        for (int i = 1; i <= n; i++){
            result *= i;
            if (result < 0){
                throw new IllegalArgumentException("Input " + n + "too big");
            }
        }
        return result;
    }
}