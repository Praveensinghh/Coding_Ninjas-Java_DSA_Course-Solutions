/*
You need to implement a class for Dequeue i.e. for double ended queue. In this queue, elements can be inserted and deleted from both the ends.
You don't need to double the capacity.

You need to implement the following functions -
1. constructor
You need to create the appropriate constructor. Size for the queue passed is 10.
2. insertFront -
This function takes an element as input and insert the element at the front of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
3. insertRear -
This function takes an element as input and insert the element at the end of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
4. deleteFront -
This function removes an element from the front of queue. Print -1 if queue is empty.
5. deleteRear -
This function removes an element from the end of queue. Print -1 if queue is empty.
6. getFront -
Returns the element which is at front of the queue. Return -1 if queue is empty.
7. getRear -
Returns the element which is at end of the queue. Return -1 if queue is empty.

Input Format:
For C++ and Java, input is already managed for you. You just have to implement given functions.
For Python:
The choice codes and corresponding input for each choice are given in a new line. The input is terminated by integer -1. The following table elaborately describes the function, their choice codes and their corresponding input - 
Alt Text

Output Format:
For C++ and Java, output is already managed for you. You just have to implement given functions.
For Python: 
The output format for each function has been mentioned in the problem description itself. 

Sample Input 1:
5 1 49 1 64 2 99 5 6 -1
Sample Output 1:
-1
64
99
Explanation:
The first choice code corresponds to getFront. Since the queue is empty, hence the output is -1. 
The following input adds 49 at the top and the resultant queue becomes: 49.
The following input adds 64 at the top and the resultant queue becomes: 64 -> 49
The following input add 99 at the end and the resultant queue becomes: 64 -> 49 -> 99
The following input corresponds to getFront. Hence the output is 64.
The following input corresponds to getRear. Hence the output is 99.
*/

/******************
 * Following is the main function we are using internally.
 * Refer this for completing the Dequeue class
 *
 * 
 * public static void main(String[] args) {
 * Scanner s = new Scanner(System.in);
 * 
 * Dequeue dq = new Dequeue(10);
 * 
 * while(true){
 * int choice = s.nextInt(),input;
 * switch (choice) {
 * case 1:
 * input = s.nextInt();
 * dq.insertFront(input);
 * break;
 * case 2:
 * input = s.nextInt();
 * dq.insertRear(input);
 * break;
 * case 3:
 * dq.deleteFront();
 * break;
 * case 4:
 * dq.deleteRear();
 * break;
 * case 5:
 * System.out.println(dq.getFront());
 * break;
 * case 6:
 * System.out.println(dq.getRear());
 * break;
 * default:
 * return ;
 * }
 * }
 * }
 ******************/

public class Dequeue {
    // Complete this class
    private int front;
    private int rear;
    private int size;
    private int[] data;

    public Dequeue(int size) {
        // Implement the Constructor
        front = -1;
        rear = -1;
        this.size = size;
        data = new int[size];
    }

    /*----------------- Public Functions of Stack -----------------*/

    public boolean isFull() {
        // Implement the isFull() function
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function
        return front == -1;
    }

    public void insertFront(int element) {
        // Implement the insertFront() function
        if (isFull()) {
            System.out.println(-1);
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }
        data[front] = element;
    }

    public void insertRear(int element) {
        // Implement the insertRear() function
        if (isFull()) {
            System.out.println(-1);
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }
        data[rear] = element;
    }

    public int deleteFront() {
        // Implement the deleteFront() function
        if (isEmpty()) {
            System.out.println(-1);
            return -1;
        }
        int temp = data[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return temp;
    }

    public int deleteRear() {
        // Implement the deleteRear() function
        if (isEmpty()) {
            System.out.println(-1);
            return -1;
        }
        int temp = data[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        return temp;
    }

    public int getFront() {
        // Implement the getFront() function
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int getRear() {
        // Implement the getRear() function
        if (isEmpty() || rear < 0) {
            return -1;
        }
        return data[rear];
    }

}