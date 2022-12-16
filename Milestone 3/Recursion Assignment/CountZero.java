/**
 * CountZero
 */
public class CountZero {

    public static int countZerosRec(int input) {
        // Write your code here
        if (input == 0) {
            return 1;
        } else if (input < 10) {
            return 0;
        } else {
            if (input % 10 == 0) {
                return 1 + countZerosRec(input / 10);
            } else {
                return countZerosRec(input / 10);
            }
        }

    }
}

/*
 * Failed One Test Case
 * 
 * public static int countZerosRec(int input) {
 * // Write your code here
 * if (input == 0) {
 * return 0;
 * }
 * if (input % 10 == 0) {
 * return 1 + countZerosRec(input / 10);
 * }
 * return countZerosRec(input / 10);
 * }
 * }
 */