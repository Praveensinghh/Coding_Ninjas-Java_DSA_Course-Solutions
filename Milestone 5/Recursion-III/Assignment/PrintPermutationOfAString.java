/*
Given a string, find and print all the possible permutations of the input string.

Note : The order of permutations are not important. Just print them in different lines.

Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
*/

public class solution {
    private static void permutationsHelper(String input, String option) {
        if (input.length() == 0) {
            System.out.println(option);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            permutationsHelper(input.substring(0, i) + input.substring(i + 1), option + input.charAt(i));
        }
    }

    public static void permutations(String input) {
        // Write your code here
        permutationsHelper(input, "");

    }
}
