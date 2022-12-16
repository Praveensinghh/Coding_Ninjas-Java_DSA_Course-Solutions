/*
Given a singly linked list of integers, sort it using 'Merge Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.

Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element

Output format :
For each test case/query, print the elements of the sorted singly linked list.
Output for every test case will be printed in a seperate line.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec

Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 

 Sample Input 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 

*/

/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class MergeSortLL {

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        // Your code goes here
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> mid = midNode(head);
        LinkedListNode<Integer> head2 = mid.next;
        mid.next = null;

        LinkedListNode<Integer> newHead1 = mergeSort(head);
        LinkedListNode<Integer> newHead2 = mergeSort(head2);

        LinkedListNode<Integer> sortedList = merge(newHead1, newHead2);
        return sortedList;
    }

    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

        LinkedListNode<Integer> temp1 = head1;
        LinkedListNode<Integer> temp2 = head2;
        LinkedListNode<Integer> mergedList = new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> currentNode = mergedList;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                currentNode.next = temp1;
                currentNode = currentNode.next;
                temp1 = temp1.next;
            } else {
                currentNode.next = temp2;
                currentNode = currentNode.next;
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            currentNode.next = temp1;
            temp1 = temp1.next;
            currentNode = currentNode.next;
        }
        while (temp2 != null) {
            currentNode.next = temp2;
            temp2 = temp2.next;
            currentNode = currentNode.next;
        }
        return mergedList.next;
    }

    public static LinkedListNode<Integer> midNode(LinkedListNode<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
