/*
Print the following pattern for the given number of rows.
Pattern for N = 5
 1    2   3    4   5
 11   12  13   14  15
 21   22  23   24  25
 16   17  18   19  20
 6    7    8   9   10
Input format : N (Total no. of rows)

Output format : Pattern in N lines

Sample Input :
4
Sample Output :
 1  2  3  4
 9 10 11 12
 13 14 15 16
 5  6  7  8
*/

public class Solution {

    /*
     * Input
     * n - number of rows
     */
    public static void printPattern(int n) {

        // Write your code here
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print((n * i) + (j + 1) + " ");
                }
                System.out.println();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print((n * i) + (j + 1) + " ");
                }
                System.out.println();
            }
        }
    }
}