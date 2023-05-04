/*
Ninja is given an easy task. He has to implement a function which calculates a^b. But there is a small difference, b is an extremely large positive number given in the form of an array.
Note: Since answers can be huge, print answer mod 1337.
It is given that b will not contain leading zeros.

Input Format:
 First line of input contains an integer a
 Second line of input contains an integer n, representing the size of the array.
 Third line of input contains an array (space separated).

 Constraints:
1 <= a <= 2^31 - 1
1 <= b.length <= 3 * 10^6
0 <= b[i] <= 9
Time Limit: 1 second

Output Format:
Single line of output printing a^b

Sample Input 1:
5
2
1 5
Sample Output:
944
Explanation:
5 to the power 15 is 30517578125. Its mod with 1337 is 944.
*/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /*
         * Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int ans = powMod(a, b, 1337);
        System.out.println(ans);
    }

    private static int powMod(int a, int[] b, int m) {
        int res = 1;
        a %= m;
        for (int i = b.length - 1; i >= 0; i--) {
            int pow = b[i];
            int val = 1;
            for (int j = 0; j < pow; j++) {
                val = (val * a) % m;
            }
            res = (res * val) % m;
            int tmp = a;
            for (int j = 0; j < 9; j++) {
                a = (a * tmp) % m;
            }
        }
        return res;
    }
}
