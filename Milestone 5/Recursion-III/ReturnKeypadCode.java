/*
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.

Note : 
1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.

Input Format :
Integer n

Output Format :
All possible strings in different lines

Constraints :
1 <= n <= 10^6

Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
*/

import java.util.ArrayList;

public class solution {

    // Return a string array that contains all the possible strings
    private static void keypadHelper(String number, int index, String option, String[] options,
            ArrayList<String> result) {
        if (index == number.length()) {
            result.add(option);
            return;
        }

        int digit = number.charAt(index) - '0';
        String optionString = options[digit - 1];
        for (int i = 0; i < optionString.length(); i++) {
            keypadHelper(number, index + 1, option + optionString.charAt(i), options, result);
        }
    }

    public static String[] keypad(int n) {
        // Write your code here
        String[] options = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> result = new ArrayList<String>();
        String number = Integer.toString(n);
        keypadHelper(number, 0, "", options, result);
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
