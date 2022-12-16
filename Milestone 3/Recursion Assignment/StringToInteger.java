/**
 * StringToInteger
 */
public class StringToInteger {

    public static int convertStringToInt(String input) {
        // Write your code here
        if (input.length() == 0) {
            return 0;
        }
        int lastDigit = input.charAt(input.length() - 1) - '0';
        return convertStringToInt(input.substring(0, input.length() - 1)) * 10 + lastDigit;
    }
}
