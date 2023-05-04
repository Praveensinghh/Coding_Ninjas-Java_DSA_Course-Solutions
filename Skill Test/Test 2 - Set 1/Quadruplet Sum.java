/*
Given an array nums of n integers and integer x, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == x
Store all such possible quadruplets in an 2D array, and return it. The order of the quadruplets does not matter.

Input Format:
First line of input contains an integer n, representing the size of the array.
Second line of input contains n space separated integers.
Third line of input contains an integer x.

Constraints:
1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

Output Format:
Return all possible quadruplets

Sample Input 1:
6
1 0 -1 0 -2 2 
0
Sample Output1:
-2 -1 1 2   
-2 0 0 2
-1 0 0 1
*/

import java.util.*;

public class Solution {
    static public List<List<Integer>> quadruplets(int[] nums, int x) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // to avoid duplicates
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // to avoid duplicates
                    continue;
                }
                int target = x - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) { // to avoid duplicates
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) { // to avoid duplicates
                            right--;
                        }
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
