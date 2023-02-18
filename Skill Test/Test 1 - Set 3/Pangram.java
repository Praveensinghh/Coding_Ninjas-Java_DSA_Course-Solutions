/*
A word or a sentence is called a pangram if all the characters of this language appear in it at least once. You are given a string s consisting of lowercase and uppercase Latin letters. Check whether this string is a pangram. Print "YES" or "NO".
We say that the string contains a letter of the Latin alphabet, if this letter occurs in the string in either uppercase or in lowercase.

Input format :
Line 1 : n (Number of characters in string)
Line 2 : Input string s

Output format :
YES or NO

Constraints :
1 <= n <= 100

Sample Input 1 :
12
toosmallword
Sample Output 1 :
NO

Sample Input 2 :
35
TheQuickBrownFoxJumpsOverTheLazyDog
Sample Output 2 :
YES
*/

import java.util.Scanner;

public class Solution {

    public static void ans(int n, String str) {
        // Write your code here
        str = str.toLowerCase();

        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                arr[str.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
