/*
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
The following line contain two integers, that denote the value of v1 and v2.

Output Format :
Print the path from v1 to v2 in reverse order.

Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second

Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1

Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :

*/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    public static ArrayList<Integer> getPath(boolean[][] graph, int v1, int v2) {
        ArrayList<Integer> path = new ArrayList<>();
        if (v1 == v2) {
            path.add(v1);
            return path;
        }
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        visited[v1] = true;
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < n; i++) {
                if (graph[curr][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    parent[i] = curr;
                    if (i == v2) {
                        break;
                    }
                }
            }
        }
        if (parent[v2] == -1) {
            return null;
        }
        int curr = v2;
        while (curr != v1) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(v1);
        return path;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        /*
         * Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split(" ");
        int n = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < e; i++) {
            strNums = br.readLine().split(" ");
            int sv = Integer.parseInt(strNums[0]);
            int ev = Integer.parseInt(strNums[1]);
            graph[sv][ev] = true;
            graph[ev][sv] = true;
        }
        strNums = br.readLine().split(" ");
        int v1 = Integer.parseInt(strNums[0]);
        int v2 = Integer.parseInt(strNums[1]);
        ArrayList<Integer> path = getPath(graph, v1, v2);
        if (path != null) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
        }
    }
}