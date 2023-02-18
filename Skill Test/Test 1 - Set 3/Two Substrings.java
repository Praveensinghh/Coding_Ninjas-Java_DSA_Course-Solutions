/*
You are given a string S. Your task is to determine if the given string S contains two non-overlapping substrings "AB" and "BA" (the substrings can go in any order). Print "YES" or "NO".
The string S contains uppercase Latin letters only.

Input format :
Line 1: String S

Output format :
YES or NO

Constraints :
1 <= n (Length of String s) <= 10^5

Sample Input 1 :
ABA
Sample Output 1 :
NO

Sample Input 2 :
BACFAB
Sample Output 2 :
YES

Sample Input 3 :
AXBYBXA
Sample Output 3 :
NO
*/

public class Solution {

    public static void twoSubstrings(String s) {
        // Write your code here

        if (s.length() < 4) {
            System.out.println("NO");
            return;
        }

        boolean found = false;

        // check if "AB" is present in the string
        if (s.contains("AB")) {
            // check if "BA" is present after "AB"
            if (s.indexOf("BA", s.indexOf("AB") + 2) != -1) {
                found = true;
            }
        }

        // check if "BA" is present in the string
        if (!found && s.contains("BA")) {
            // check if "AB" is present after "BA"
            if (s.indexOf("AB", s.indexOf("BA") + 2) != -1) {
                found = true;
            }
        }

        // print the result
        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}