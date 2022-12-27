/*
Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.

Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 1 : Binary Tree 1 (separated by space)

Sample Input 1 :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
9
3
6
5
*/

import java.util.ArrayList;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class LongestLeafToRootPath {

    /*
     * Binary Tree Node class
     * 
     * class BinaryTreeNode<T> {
     * T data;
     * BinaryTreeNode<T> left;
     * BinaryTreeNode<T> right;
     * 
     * public BinaryTreeNode(T data) {
     * this.data = data;
     * }
     * }
     */

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root == null) {
            return null;
        }

        ArrayList<Integer> left = longestRootToLeafPath(root.left);
        ArrayList<Integer> right = longestRootToLeafPath(root.right);

        if (left == null && right == null) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }

        if (left == null) {
            right.add(root.data);
            return right;
        }

        if (right == null) {
            left.add(root.data);
            return left;
        }

        if (left.size() > right.size()) {
            left.add(root.data);
            return left;
        } else {
            right.add(root.data);
            return right;
        }

    }
}