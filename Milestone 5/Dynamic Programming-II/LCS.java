/*
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.

Input format :
The first line of input contains the string 'S' of length 'M'.
The second line of the input contains the string 'T' of length 'N'.

Output format :
Return the length of the Longest Common Subsequence.

Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec

Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 

Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
*/

public class Solution {

    private static int lcs(String s, int i, String t, int j, int[][] dp) {

        if (i == s.length() || j == t.length()) {
            return 0;
        }

        int ans;

        if (s.charAt(i) == t.charAt(j)) {
            int smallAnswer;
            if (dp[i + 1][j + 1] == -1) {
                smallAnswer = lcs(s, i + 1, t, j + 1, dp);
                dp[i + 1][j + 1] = smallAnswer;
            } else {
                smallAnswer = dp[i + 1][j + 1];
            }
            ans = 1 + smallAnswer;
        } else {
            int ans1;
            if (dp[i + 1][j] == -1) {
                ans1 = lcs(s, i + 1, t, j, dp);
                dp[i + 1][j] = ans1;
            } else {
                ans1 = dp[i + 1][j];
            }
            int ans2;
            if (dp[i][j + 1] == -1) {
                ans2 = lcs(s, i, t, j + 1, dp);
                dp[i][j + 1] = ans2;
            } else {
                ans2 = dp[i][j + 1];
            }
            ans = Math.max(ans1, ans2);
        }
        return ans;
    }

    public static int lcs(String s, String t) {
        // Your code goes here
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(s, 0, t, 0, dp);
    }
}