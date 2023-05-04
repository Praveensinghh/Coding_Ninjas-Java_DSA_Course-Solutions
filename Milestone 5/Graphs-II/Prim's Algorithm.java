/*
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.

For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.

Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

Output Format :
Print the MST, as described in the task.

Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec

Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 1 3
1 2 1
0 3 5
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] graph = new int[v][v];
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        boolean isPathFound = false;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == end) {
                isPathFound = true;
                break;
            }
            for (int i = 0; i < v; i++) {
                if (!visited[i] && graph[curr][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                    parent[i] = curr;
                }
            }
        }
        if (isPathFound) {
            int curr = end;
            while (curr != -1) {
                System.out.print(curr + " ");
                curr = parent[curr];
            }
        }
    }
}
