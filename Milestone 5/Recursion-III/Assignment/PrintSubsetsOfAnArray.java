/*
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note : The order of subsets are not important. Just print the subsets in different lines.

Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)

Constraints :
1 <= n <= 15

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

public class solution {

    public static void printSubsets(int input[], int output[], int start) {
        if (start == input.length) {
            for (int i = 0; i < output.length; i++) {
                if (output[i] != 0) {
                    System.out.print(output[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        output[start] = input[start];
        printSubsets(input, output, start + 1);
        output[start] = 0;
        printSubsets(input, output, start + 1);
    }

    public static void printSubsets(int input[]) {
        // Write your code here
        int[] output = new int[input.length];
        printSubsets(input, output, 0);

    }
}
