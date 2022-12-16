
/*
For a given a string(str), find and return the highest occurring character.

Example:
Input String: "abcdeapapqarr"
Expected Output: 'a'
Since 'a' has appeared four times in the string which happens to be the highest frequency character, the answer would be 'a'.
If there are two characters in the input string with the same frequency, return the character which comes first.

Consider:
Assume all the characters in the given string to be in lowercase always.

Input Format:
The first and only line of input contains a string without any leading and trailing spaces.

Output Format:
The only line of output prints the updated string. 

Note:
You are not required to print anything explicitly. It has already been taken care of.

Constraints:
0 <= N <= 10^6
Where N is the length of the input string.
Time Limit: 1 second

Sample Input 1:
abdefgbabfba
Sample Output 1:
b

Sample Input 2:
xy
Sample Output 2:
x
*/
import java.util.Arrays;
import java.util.Scanner;

/**
 * HighestOccuringCharacter
 */
public class HighestOccuringCharacter {

    // public static char highestOccuringChar(String str) {
    // // Your code goes here

    // int highestCount = 0;
    // char highestCountCharacter = 'a';

    // for (int i = 0; i < str.length(); i++) {
    // int count = 0;
    // for (int j = 0; j < str.length(); j++) {
    // if (str.charAt(i) == str.charAt(j)) {
    // count++;
    // }
    // }
    // if (count >= highestCount) {
    // highestCount = count;
    // highestCountCharacter = str.charAt(i);
    // }
    // }
    // return highestCountCharacter;
    // }

    public static char highestOccuringChar(String str) {
        // Your code goes here

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        int max = 0;
        char maxChar = 'a';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                maxChar = (char) (i + 'a');
            }
        }
        return maxChar;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(highestOccuringChar(input));

    }
}
