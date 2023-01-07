/*
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.

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

public class solution {

    private static void keypadHelper(String number, int index, String option, String[] options) {
        if (index == number.length()) {
            System.out.println(option);
            return;
        }

        int digit = number.charAt(index) - '0';
        String optionString = options[digit - 1];
        for (int i = 0; i < optionString.length(); i++) {
            keypadHelper(number, index + 1, option + optionString.charAt(i), options);
        }
    }

    public static void printKeypad(int input) {
        // Write your code here
        String[] options = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        String number = Integer.toString(input);
        keypadHelper(number, 0, "", options);

    }
}
