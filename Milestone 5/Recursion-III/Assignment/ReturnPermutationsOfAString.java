/*
Given a string, find and return all the possible permutations of the input string.

Note : The order of permutations are not important.

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

import java.util.ArrayList;

public class solution {
    private static void permutationsHelper(String input, String option, ArrayList<String> result) {
        if (input.length() == 0) {
            result.add(option);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            permutationsHelper(input.substring(0, i) + input.substring(i + 1), option + input.charAt(i),
                    result);
        }
    }

    public static String[] permutationOfString(String input) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        permutationsHelper(input, "", result);
        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

}
