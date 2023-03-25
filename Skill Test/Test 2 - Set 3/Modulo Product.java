
/*
Ninja got an easy assignment from his professor but he is unable to solve this. So he needs your help to complete the assignment.
In the assignment, he is given two integers A and B and he needs to output the product of all numbers from 1 to A modulo B, where 1 and A are inclusive.
For example, if A=5 and B=7, the answer will be ( 1 * 2 * 3 * 4 * 5 ) % 7 = 1 so the final answer is 1.

Input format:
The first line of input will contain an integer T, that denote the number of test cases.
Every test case will consist of one single line and that line will contain two integers: A and B.

Constraints:
1<=T<=50
1<=A<=10^9
1<=B<=10^5
Time Limit: 1 second

Output format:
For every test case, print the output in a newline.

Sample Input 1
4
8 10
5 140
18 19
20 21
Sample Output 1:
0
120
18
0
*/

import java.util.Scanner;

public class Main {

    public static int getProductModulo(int A, int B) {
        if (A == 0 || B == 1) {
            return 0;
        }
        int product = 1;
        for (int i = 1; i <= A; i++) {
            product = (product * i) % B;
            if (product == 0) {
                return 0;
            }
        }
        return product;
    }

    public static void main(String[] args) {
        /*
         * Your class should be named Main.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(getProductModulo(a, b));
        }
    }
}
