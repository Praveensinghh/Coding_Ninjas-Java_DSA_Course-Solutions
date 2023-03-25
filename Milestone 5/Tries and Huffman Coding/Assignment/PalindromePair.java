/*
Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, which itself is a palindrome.
The function should return either true or false. You don't have to print anything.

Input Format :
The first line of the test case contains an integer value denoting 'n'.
The following contains 'n' number of words each separated by a single space.

Output Format :
The first and only line of output contains true if the conditions described in the task are met and false otherwise.

Constraints:
0 <= n <= 10^5
Time Limit: 1 sec

Sample Input 1 :
4
abc def ghi cba
Sample Output 1 :
true
Explanation of Sample Input 1:
"abc" and "cba" forms a palindrome

Sample Input 2 :
2
abc def
Sample Output 2 :
false
Explanation of Sample Input 2:
Neither their exists a pair which forms a palindrome, nor any of the words is a palindrome in itself. Hence, the output is 'false.'
*/

import java.util.*;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

public class Trie {

    private TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return search(child, word.substring(1));

    }

    public boolean search(String word) {
        return search(root, word);
    }

    private void print(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        if (root.isTerminating) {
            System.out.println(word);
        }

        for (TrieNode child : root.children) {
            if (child == null) {
                continue;
            }
            String fwd = word + child.data;
            print(child, fwd);
        }
    }

    public void print() {
        print(this.root, "");
    }

    /* ..................... Palindrome Pair................... */

    private boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindromePair(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }

        if (root.isTerminating && isPalindrome(word)) {
            return true;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];

        if (child == null) {
            return false;
        }

        return isPalindromePair(child, word.substring(1));
    }

    public boolean isPalindromePair(ArrayList<String> words) {
        // Build a Trie with reverse of each word
        Trie reverseTrie = new Trie();
        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            reverseTrie.add(reverseWord);
        }

        // Check if any word in the list is a palindrome or a pair of words can be
        // joined to form a palindrome
        for (String word : words) {
            if (reverseTrie.search(word)) {
                return true; // word itself is a palindrome
            }
            if (isPalindromePair(reverseTrie.root, word)) {
                return true; // pair of words can be joined to form a palindrome
            }
        }
        return false;
    }

}