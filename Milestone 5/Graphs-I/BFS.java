/*
Given an undirected and disconnected graph G(V, E), print its BFS traversal.

Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.

Output Format :
Print the BFS Traversal, as described in the task.

Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second

Sample Input 1:
4 4
0 1
0 3
1 2
2 3

Sample Output 1:
0 1 3 2
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static void BFSTraversal(int[][] adjacencyMatrix, int sv, boolean[] visited) {
        Queue<Integer> pendingVertices = new LinkedList<Integer>();
        pendingVertices.add(sv);
        visited[sv] = true;
        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void BFSTraversal(int[][] adjacencyMatrix) {
        boolean[] visited = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                BFSTraversal(adjacencyMatrix, i, visited);
            }
        }
    }

    private static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        /*
         * Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] adj = new int[v][v];
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adj[v1][v2] = 1;
            adj[v2][v1] = 1;
        }
        BFSTraversal(adj);
    }
}