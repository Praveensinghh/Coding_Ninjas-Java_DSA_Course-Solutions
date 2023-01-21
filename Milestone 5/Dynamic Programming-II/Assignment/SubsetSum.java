/*
You are given a set of N integers. You have to return true if there exists a subset that sum up to K, otherwise return false.

Input Format
The first line of the test case contains an integer 'N' representing the total elements in the set.
The second line of the input contains N integers separated by a single space.    
The third line of the input contains a single integer, denoting the value of K.

Output Format
Output Yes if there exists a subset whose sum is k, else output No.

Constraints :
1 <= N <= 10^3
1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
1 <= K <= 10^3

Time Limit: 1 sec

Sample Input 1 :
4
4 3 5 2
13
Sample Output 1 :
No

Sample Input 2 :
5
4 2 5 6 7
14
Sample Output 2 :
Yes
*/

public class Solution {

    private static boolean isSubsetPresent(int[] arr, int i, int sum, boolean[][] dp) {

        if (sum == 0) {
            return true;
        }

        if (i == arr.length) {
            return false;
        }

        if (dp[i][sum]) {
            return dp[i][sum];
        }

        if (arr[i] <= sum) {
            dp[i][sum] = isSubsetPresent(arr, i + 1, sum - arr[i], dp) || isSubsetPresent(arr, i + 1, sum, dp);
        } else {
            dp[i][sum] = isSubsetPresent(arr, i + 1, sum, dp);
        }

        return dp[i][sum];
    }

    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        boolean dp[][] = new boolean[n + 1][sum + 1];
        isSubsetPresent(arr, 0, sum, dp);
    }
}