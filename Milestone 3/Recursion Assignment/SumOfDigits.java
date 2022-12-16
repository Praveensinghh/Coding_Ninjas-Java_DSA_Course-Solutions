/**
 * SumOfDigits
 */
public class SumOfDigits {

    public static int sumOfDigits(int input) {
        // Write your code here
        if (input == 0) {
            return 0;
        }
        return input % 10 + sumOfDigits(input / 10);
    }
}
