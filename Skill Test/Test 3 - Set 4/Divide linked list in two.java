/*
Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
Nodes should be in the reverse order of which they occurred in the source list.
Print both linked lists in different lines.

Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)

Output format :
Line 1 : Output Linked List 1 elements (separated by space)
Line 2 : Output Linked List 2 elements (separated by space)

Constraints :
1 <= n <= 10^4

Sample Input :
 8 2 5 9 1 4 3 7 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 8.
Sample Output :
 3 1 5 8
 7 4 9 2
*/

/***********
 
Following is the Linked list node structure already written 
 
class ListNode<t> {
	public t data;
	 public ListNode<t> next;
	 public ListNode(t data)
	 {
		 this.data=data;
	 }
}

************/

import java.util.*;

public class solution {

    public static void make2List(ListNode<Integer> head) {
        ListNode<Integer> A = null, B = null;
        ListNode<Integer> currA = null, currB = null;
        ListNode<Integer> curr = head;
        boolean addToA = true;
        while (curr != null) {
            ListNode<Integer> newNode = new ListNode<>(curr.data);
            if (addToA) {
                if (A == null) {
                    A = newNode;
                    currA = A;
                } else {
                    currA.next = newNode;
                    currA = newNode;
                }
            } else {
                if (B == null) {
                    B = newNode;
                    currB = B;
                } else {
                    currB.next = newNode;
                    currB = newNode;
                }
            }
            curr = curr.next;
            addToA = !addToA;
        }
        printListReverseOrder(A);
        System.out.println();
        printListReverseOrder(B);
    }

    private static void printListReverseOrder(ListNode<Integer> head) {
        if (head == null) {
            return;
        }
        printListReverseOrder(head.next);
        System.out.print(head.data + " ");
    }
}
