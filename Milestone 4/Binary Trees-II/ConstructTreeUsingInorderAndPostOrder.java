/*
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements. 

Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.
The second line of input contains N integers, all separated by a single space. It represents the Postorder-traversal of the binary tree.
The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.

Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.

Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec

Sample Input 1:
7
4 5 2 6 7 3 1 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 

Sample Input 2:
6
2 9 3 6 10 5 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 
*/

/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ConstructTreeUsingInorderAndPostOrder {

    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        // Your code goes here
        BinaryTreeNode<Integer> root = buildTreeHelper(postOrder, inOrder, 0, postOrder.length - 1, 0,
                inOrder.length - 1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] postOrder, int[] inOrder, int postStartIndex,
            int postEndIndex, int inStartIndex, int inEndIndex) {
        // Your code goes here
        if (postStartIndex > postEndIndex || inStartIndex > inEndIndex) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postOrder[postEndIndex]);

        int inRootIndex = -1;
        for (int i = inStartIndex; i <= inEndIndex; i++) {
            if (inOrder[i] == root.data) {
                inRootIndex = i;
                break;
            }
        }

        if (inRootIndex == -1) {
            return null;
        }

        int leftInStartIndex = inStartIndex;
        int leftInEndIndex = inRootIndex - 1;

        int leftPostStartIndex = postStartIndex;
        int leftSubtreeLength = leftInEndIndex - leftInStartIndex + 1;
        int leftPostEndIndex = leftPostStartIndex + (leftSubtreeLength - 1);

        int rightInStartIndex = inRootIndex + 1;
        int rightInEndIndex = inEndIndex;

        int rightPostStartIndex = leftPostEndIndex + 1;
        int rightPostEndIndex = postEndIndex - 1;

        root.left = buildTreeHelper(postOrder, inOrder, leftPostStartIndex, leftPostEndIndex, leftInStartIndex,
                leftInEndIndex);
        root.right = buildTreeHelper(postOrder, inOrder, rightPostStartIndex, rightPostEndIndex, rightInStartIndex,
                rightInEndIndex);

        return root;
    }
}