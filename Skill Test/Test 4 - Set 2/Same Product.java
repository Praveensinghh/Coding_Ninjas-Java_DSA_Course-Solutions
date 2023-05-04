/*
Given an array of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of the array, and a != b != c != d.

Input Format:
First line of input contains an integer N, representing the number of elements in array
Second line of input contains N space separated integers

Output Format:
Print the required count

Sample Input 1:
4
2 3 4 6
Sample Output 1:
8
Explanation:
There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        // Take input as instructed
        // Print output as instructed
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }
}