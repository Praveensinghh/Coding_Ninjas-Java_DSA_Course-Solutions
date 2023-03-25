/*
You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
Note: Take absolute difference between the elements of the array.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of K.

Output format :
The first and only line of output contains count of all such pairs which have an absolute difference of K. 

Constraints :
0 <= n <= 10^4
Time Limit: 1 sec

Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2

Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6
*/

import java.util.*;

public class Solution {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        // Write your code here
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        if (k == 0) {
            for (int num : freq.keySet()) {
                int f = freq.get(num);
                if (f >= 2) {
                    count += f * (f - 1) / 2; // n choose 2
                }
            }
        } else {
            for (int num : freq.keySet()) {
                if (freq.containsKey(num + k)) {
                    count += freq.get(num) * freq.get(num + k);
                }
            }
        }

        return count;
    }
}