/*
Implement the BST class which includes following functions -

1. insert -
Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
2. search
Given an element, find if that is present in BST or not. Return true or false.
3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -

Print the BST in in the following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.
*/

/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

/* 
* Main Method being used internally
*	public static void main(String[] args) throws IOException {
*		BinarySearchTree bst = new BinarySearchTree();
*		int choice, input;
*		int q = Integer.parseInt(br.readLine());
*		while (q-- > 0) {
*			st = new StringTokenizer(br.readLine());
*			choice = Integer.parseInt(st.nextToken());
*			switch (choice) {
*			case 1:
*				input = Integer.parseInt(st.nextToken());
*				bst.insert(input);
*				break;
*				case 2:
*				input = Integer.parseInt(st.nextToken());
*				bst.remove(input);
*				break;
*			case 3:
*				input = Integer.parseInt(st.nextToken());
*				System.out.println(bst.search(input));
*				break;
*			default:
*				bst.printTree();
*				break;
*			}
*		}
*	}
*/

class BinaryTreeNode<T> {

    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class BSTClass {
    static BinaryTreeNode<Integer> root;

    public void insert(int data) {
        // Implement the insert() function
        root = insert(root, data);
    }

    private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
        // Implement the insert() function
        if (root == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }


        return root;
    }

    public void remove(int data) {
        // Implement the remove() function
        root = remove(root, data);
    }

    private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data) {
        // Implement the remove() function
        if (root == null) {
            return null;
        }

        if (root.data > data) {
            root.left = remove(root.left, data);
            return root;
        } else if (root.data < data) {
            root.right = remove(root.right, data);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }

                root.data = minNode.data;
                root.right = remove(root.right, minNode.data);
                return root;
            }
        }
    }

    public void printTree() {
        // Implement the printTree() function
        printTree(root);
    }

    private static void printTree(BinaryTreeNode<Integer> root) {
        // Implement the printTree() function
        if (root == null) {
            return;
        }

        String toBePrinted = root.data + ":";
        if (root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }

        if (root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }

        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

    public boolean search(int data) {
        // Implement the search() function
        return search(root, data);
    }

    private static boolean search(BinaryTreeNode<Integer> root, int data) {
        // Implement the search() function
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (root.data > data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
}