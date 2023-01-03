/*
Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.

Output Format :
The first and only line of output contains true if it represents max-heap and false if it is not a max-heap.

Constraints:
1 <= N <= 10^5
1 <= Ai <= 10^5
Time Limit: 1 sec

Sample Input 1:
8
42 20 18 6 14 11 9 4
Sample Output 1:
true
*/

public class Solution {

    public static boolean checkMaxHeap(int arr[]) {
        /*
         * Your class should be named Solution Don't write main(). Don't read input, it
         * is passed as function argument. Return output and don't print it. Taking
         * input and printing output is handled automatically.
         */

        return checkMaxHeap(arr, 0);
    }

    private static boolean checkMaxHeap(int[] arr, int i) {

        if (i >= arr.length) {
            return true;
        }
        
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        if (leftChildIndex >= arr.length) {
            return true;
        }

        if (arr[parentIndex] < arr[leftChildIndex]) {
            return false;
        }

        boolean leftAns = checkMaxHeap(arr, leftChildIndex);
        boolean rightAns = checkMaxHeap(arr, rightChildIndex);

        return leftAns && rightAns;
    }
}