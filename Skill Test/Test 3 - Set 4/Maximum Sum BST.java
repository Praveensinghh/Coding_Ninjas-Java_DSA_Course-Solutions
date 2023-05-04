/*
Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Input Format:
The first and only line of input contains data of the nodes of the tree in level order form. The order is: data for root node, data for left child to root node,  data for right child to root node and so on and so forth for each node. The data of the nodes of the tree is separated by space. Data -1 denotes that the node doesn't exist.

Output Format:
Print the maximum sum

Sample Input 1:
1 4 3 2 4 2 5 -1 -1 -1 -1 -1 -1 4 6 -1 -1 -1 -1
Sample Output 1:
20
*/

import java.util.*;

public class Solution {
    public static int maxSumBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        int[] result = traverse(root);
        return result[2];
    }

    private static int[] traverse(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0 };
        }
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);
        if (node.data > left[1] && node.data < right[0]) {
            int size = left[3] + right[3] + 1;
            int sum = node.data + left[2] + right[2];
            int min = Math.min(node.data, left[0]);
            int max = Math.max(node.data, right[1]);
            return new int[] { min, max, sum, size };
        }
        return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2]), 0 };
    }
}
