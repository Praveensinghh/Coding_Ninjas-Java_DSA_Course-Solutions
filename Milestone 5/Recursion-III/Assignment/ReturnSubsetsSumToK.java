/*
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note : The order of subsets are not important.

Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 

Constraints :
1 <= n <= 20

Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1
*/

public class solution {

    public static int[][] subsetsSumK(int input[], int k, int start) {
        if (start == input.length) {
            if (k == 0) {
                int[][] ans = new int[1][0];
                return ans;
            } else {
                int[][] ans = new int[0][0];
                return ans;
            }
        }
        int[][] smallAns1 = subsetsSumK(input, k, start + 1);
        int[][] smallAns2 = subsetsSumK(input, k - input[start], start + 1);
        int[][] ans = new int[smallAns1.length + smallAns2.length][];
        int i = 0;
        for (; i < smallAns1.length; i++) {
            ans[i] = new int[smallAns1[i].length];
            for (int j = 0; j < smallAns1[i].length; j++) {
                ans[i][j] = smallAns1[i][j];
            }
        }
        for (int j = 0; j < smallAns2.length; j++) {
            ans[i] = new int[smallAns2[j].length + 1];
            ans[i][0] = input[start];
            for (int l = 1; l < ans[i].length; l++) {
                ans[i][l] = smallAns2[j][l - 1];
            }
            i++;
        }
        return ans;
    }

    // Return a 2D array that contains all the subsets which sum to k
    public static int[][] subsetsSumK(int input[], int k) {
        // Write your code here
        return subsetsSumK(input, k, 0);
    }
}
