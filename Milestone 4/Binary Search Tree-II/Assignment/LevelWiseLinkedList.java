/*
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.

Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.

Output format :
Each level linked list is printed in new line (elements are separated by space).

Constraints:
Time Limit: 1 second

Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
5 
6 10 
2 3 
9
*/

import java.util.ArrayList;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class LevelWiseLinkedList {
    /*
     * BinaryTreeNode class
     * 
     * class BinaryTreeNode<T>
     * {
     * T data;
     * BinaryTreeNode<T> left;
     * BinaryTreeNode<T> right;
     * public BinaryTreeNode(T data)
     * {
     * this.data = data;
     * }
     * }
     */
    /*
     * LinkedListNode Class
     * class LinkedListNode<T>
     * {
     * T data;
     * LinkedListNode<T> next;
     * public LinkedListNode(T data)
     * {
     * this.data = data;
     * }
     * }
     */
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        // Write your code here

        if (root == null) {
            return null;
        }

        ArrayList<LinkedListNode<Integer>> result = new ArrayList<>();
        LinkedListNode<Integer> head = new LinkedListNode<>(root.data);
        result.add(head);

        ArrayList<BinaryTreeNode<Integer>> queue = new ArrayList<>();
        queue.add(root);

        return constructLinkedListForEachLevelHelper(queue, result);
    }

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevelHelper(
            ArrayList<BinaryTreeNode<Integer>> queue, ArrayList<LinkedListNode<Integer>> result) {
        if (queue.isEmpty()) {
            return result;
        }

        ArrayList<BinaryTreeNode<Integer>> newQueue = new ArrayList<>();
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        for (BinaryTreeNode<Integer> node : queue) {
            if (node.left != null) {
                newQueue.add(node.left);
                if (head == null) {
                    head = new LinkedListNode<>(node.left.data);
                    tail = head;
                } else {
                    tail.next = new LinkedListNode<>(node.left.data);
                    tail = tail.next;
                }
            }
            if (node.right != null) {
                newQueue.add(node.right);
                if (head == null) {
                    head = new LinkedListNode<>(node.right.data);
                    tail = head;
                } else {
                    tail.next = new LinkedListNode<>(node.right.data);
                    tail = tail.next;
                }
            }
        }

        if (head != null) {
            result.add(head);
        }

        return constructLinkedListForEachLevelHelper(newQueue, result);
    }
}
