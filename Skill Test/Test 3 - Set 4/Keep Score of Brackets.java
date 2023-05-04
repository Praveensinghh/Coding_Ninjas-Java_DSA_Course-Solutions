/*
Vaibhavi loves to play with strings of brackets. She likes the balanced string of brackets, so much so, that she has decided to score them. She follows the following grading system:
1. A bracket group like () has score of  3
2. XY has a score of score X + Y, where X and Y are balanced parentheses strings.
3. A bracket group like (A) has score 3 * A, where A is a balanced parentheses string.
Given a balanced paranthesis string, your job is to find the score of it and solve the riddle.

Input Format:
First and only line of input contains a balanced paranthesis string, S.

Constraints:
S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50

Output Format:
Print the score of the input string.

Sample Input:
(()(()))
Sample Output:
36
Explanation:
Let us break down the () first.
(3(3)) 
Now, (3) evaluates to 9
(3 9)
3 and 9 are two pairs of balanced results, hence add them
(12)
This evaluates to 24.
*/

import java.util.*;

class Solution {
    static public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int currentScore = 0;
                while (stack.peek() != -1) {
                    currentScore += stack.pop();
                }
                stack.pop(); // Remove the opening bracket
                stack.push(currentScore == 0 ? 3 : 3 * currentScore);
            }
        }

        int totalScore = 0;
        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }
}
