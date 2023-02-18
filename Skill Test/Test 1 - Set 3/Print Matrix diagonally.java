/*
Given a matrix of integers, you need to print it diagonally. Thats is, if input is a 3 x 3 matrix, then order will be -
(0, 0), (0, 1), (1, 0), (2, 0), (1, 1), (0, 2), (1, 2), (2, 1), (2, 2)
For eg. if input is -
 1  2  3
 4  5  6  
 7  8  9
Output : 1 2 4 7 5 3 6 8 9.

Input format :
Line 1 : m (No. of rows) and n (No. of columns)
Next m lines : Each row elements in different line

Output format : Print elements in specified order, separated by space

Sample Input :
4 4
 1  2   3  10
 4  5   6  11
 7  8   9  12
13 14  15  16
Sample Output :
1 2 4 7 5 3 10 6 8 13 14 9 11 12 15 16
*/

public class Solution {

    public static void printInDiagonalForm(int[][] arr) {

        int n = arr.length;

        // Initialize indexes of element to be printed next
        int i = 0, j = 0;

        // Direction is initially from down to up
        boolean isUp = true;

        // Traverse the matrix till all elements get traversed
        for (int k = 0; k < n * n;) {
            // If isUp = true then traverse from downward
            // to upward
            if (isUp) {
                for (; i >= 0 && j < n; j++, i--) {
                    System.out.print(arr[i][j] + " ");
                    k++;
                }

                // Set i and j according to direction
                if (i < 0 && j <= n - 1)
                    i = 0;
                if (j == n) {
                    i = i + 2;
                    j--;
                }
            }

            // If isUp = 0 then traverse up to down
            else {
                for (; j >= 0 && i < n; i++, j--) {
                    System.out.print(arr[i][j] + " ");
                    k++;
                }

                // Set i and j according to direction
                if (j < 0 && i <= n - 1)
                    j = 0;
                if (i == n) {
                    j = j + 2;
                    i--;
                }
            }

            // Revert the isUp to change the direction
            isUp = !isUp;
        }
    }
}