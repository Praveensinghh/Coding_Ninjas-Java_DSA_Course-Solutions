/*
Given an array A and an integer K, print all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note : The order of subsets are not important. Just print them in different lines.

Input format :
Line 1 : Size of input array
Line 2 : Array elements separated by space
Line 3 : K 

Sample Input:
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output:
3 3
5 1
*/

import java.util.ArrayList;

public class solution {

    private static void printSubsetsSumTok(int[] input, int k, int start, ArrayList<Integer> output) {
        if (k == 0) {
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i) + " ");
            }
            System.out.println();
            return;
        }
        if (start == input.length) {
            return;
        }
        if (input[start] <= k) {
            output.add(input[start]);
            printSubsetsSumTok(input, k - input[start], start + 1, output);
            output.remove(output.size() - 1);
        }
        printSubsetsSumTok(input, k, start + 1, output);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        // Write your code here
        ArrayList<Integer> output = new ArrayList<>();
        printSubsetsSumTok(input, k, 0, output);
    }
}
