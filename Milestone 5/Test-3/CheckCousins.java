/*
Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
Do it in O(n).

Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Line 2 : integer value of p 
Line 3 : Integer value of q

Output format :
true or false

Constraints :
1 <= N <= 10^5

Sample Input :
5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
2
4
Sample Output :
true
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

public class CheckCousins {

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

    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        // Write your code here

        if (root == null) {
            return false;
        }

        ArrayList<Integer> pathToP = new ArrayList<Integer>();
        ArrayList<Integer> pathToQ = new ArrayList<Integer>();

        findPath(root, p, pathToP);
        findPath(root, q, pathToQ);

        if (pathToP.size() == pathToQ.size()) {
            if (pathToP.get(pathToP.size() - 2) != pathToQ.get(pathToQ.size() - 2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean findPath(BinaryTreeNode<Integer> root, int data, ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == data) {
            return true;
        }

        if (findPath(root.left, data, path) || findPath(root.right, data, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

}
