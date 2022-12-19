/*
Given two string s and t, write a function to check if s contains all characters of t (in the same order as they are in string t).
Return true or false.
Do it recursively.

E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same order. So function will return true.

Input Format :
Line 1 : String s
Line 2 : String t

Output Format :
true or false

Sample Input 1 :
abchjsgsuohhdhyrikkknddg
coding
Sample Output 1 :
true

Sample Input 2 :
abcde
aeb
Sample Output 2 :
false
*/

public class DoesSContainT {
    public static boolean checkSequence(String a, String b) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        if (b.length() == 0) {
            // base case: if t is empty, return True
            return true;
        } else if (a.length() == 0) {
            // base case: if s is empty but t is not, return False
            return false;
        } else if (a.charAt(0) == b.charAt(0)) {
            // if the first characters of s and t match, check the rest of the strings
            return checkSequence(a.substring(1), b.substring(1));
        } else {
            // if the first characters of s and t do not match, check the rest of s
            return checkSequence(a.substring(1), b);
        }
    }
}