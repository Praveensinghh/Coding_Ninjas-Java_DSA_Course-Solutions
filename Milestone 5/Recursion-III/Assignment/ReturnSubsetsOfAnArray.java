/*
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note : The order of subsets are not important.

Input format :
Line 1 : Size of array
Line 2 : Array elements (separated by space)

Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 
*/

import java.util.ArrayList;

public class solution {

    public static int[][] subsets(int input[], int start) {
        if (start == input.length) {
            int[][] ans = new int[1][0];
            return ans;
        }
        int[][] smallAns = subsets(input, start + 1);
        int[][] ans = new int[2 * smallAns.length][];
        int i = 0;
        for (; i < smallAns.length; i++) {
            ans[i] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++) {
                ans[i][j] = smallAns[i][j];
            }
        }
        for (int j = 0; j < smallAns.length; j++) {
            ans[i] = new int[smallAns[j].length + 1];
            ans[i][0] = input[start];
            for (int l = 1; l < ans[i].length; l++) {
                ans[i][l] = smallAns[j][l - 1];
            }
            i++;
        }
        return ans;
    }

    // Return a 2D array that contains all the subsets
    public static int[][] subsets(int input[]) {
        // Write your code here
        return subsets(input, 0);
    }
}
