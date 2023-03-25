/*
This year politicians and economists have been invited to participate in Stanford Institute for Theoretical Economics (SITE 2021) conference as guests. You have to accommodate them in r rooms such that-
No room may remain empty.
A room may contain either only politicians or only economists, not both.
No economists are allowed to stay alone in a room.
Find the number of ways to place them. Note though, that all the rooms are identical. But each of the economists and politicians are unique.
Since the number of ways can be very large, print the answer modulo 998,244,353.

Input Format:
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains three space-separated integers p, q and r denoting the number of politicians, economists and rooms.

Output Format:
For each test case, output the number of ways to place them modulo 998,244,353.

Constraints
1≤T≤100
1≤p,q,r≤100

Sample Input:
4
2 1 4
2 4 4
2 5 4 
2 8 4
Sample Output:
0
3
10
609
Explanation:
 Test case 1: 4 rooms and 3 people. A room would remain empty.
 Test case 2: There are 4 rooms and 6 people. There are 3 possible ways to distribute these 6 people in 3 rooms.

{Politician 1}, {Politician 2}, {Economist 1, Economist 2}, {Economist 3, Economist 4}
{Politician 1}, {Politician 2}, {Economist 1, Economist 3}, {Economist 2, Economist 4}
{Politician 1}, {Politician 2}, {Economist 1, Economist 4}, {Economist 2, Economist 3}
 Please note that the rooms are identical.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    static int MOD = 998244353;

    private static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (int) ((long) ans * i % MOD);
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int r = scanner.nextInt();
            int[][][] dp = new int[p + 1][q + 1][r + 1];
            for (int i = 0; i <= p; i++) {
                for (int j = 0; j <= q; j++) {
                    for (int k = 0; k <= r; k++) {
                        if (i + j < k) {
                            dp[i][j][k] = 0;
                        } else if (i + j == k) {
                            dp[i][j][k] = factorial(i + j);
                        } else if (j == 1) {
                            dp[i][j][k] = 0;
                        } else if (k == 1) {
                            dp[i][j][k] = 1;
                        } else {
                            dp[i][j][k] = (int) (((long) i * dp[i - 1][j][k - 1] + (long) j * dp[i][j - 1][k - 1])
                                    % MOD);
                        }
                    }
                }
            }
            System.out.println(dp[p][q][r]);
        }
    }

}