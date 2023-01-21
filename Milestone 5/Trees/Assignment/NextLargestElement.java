/*
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
Return NULL if no node is present with value greater than n.

Input format :
Line 1 : Integer n
Line 2 : Elements in level order form separated by space (as per done in class). Order is -
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
Output format : Node with value just greater than n.

Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
20

Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
30
*/

import java.util.ArrayList;

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}

public class Solution {

    /*
     * TreeNode structure
     * 
     * class TreeNode<T> {
     * T data;
     * ArrayList<TreeNode<T>> children;
     * 
     * TreeNode(T data){
     * this.data = data;
     * children = new ArrayList<TreeNode<T>>();
     * }
     * }
     */

    private static TreeNode<Integer> findNextLargestNode(TreeNode<Integer> root, int n, int nextLargerElement) {

        if (root == null) {
            return null;
        }

        if (root.data > n && root.data < nextLargerElement) {
            nextLargerElement = root.data;
        }

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            TreeNode<Integer> nextLargestNode = findNextLargestNode(child, n, nextLargerElement);
            if (nextLargestNode != null && nextLargestNode.data < nextLargerElement) {
                nextLargerElement = nextLargestNode.data;
            }
        }

        if (nextLargerElement == Integer.MAX_VALUE) {
            return null;
        }

        TreeNode<Integer> nextLargestNode = new TreeNode<Integer>(nextLargerElement);
        return nextLargestNode;
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        // Write your code here

        return findNextLargestNode(root, n, Integer.MAX_VALUE);
    }
}
