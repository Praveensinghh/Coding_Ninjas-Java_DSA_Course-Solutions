/*
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.

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
Time Limit: 1 sec

Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
1 2 1
0 1 3
0 3 5
*/

import java.util.*;

public class Solution {
    static class Edge {
        int v1;
        int v2;
        int w;

        Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    private static int findParent(int v, int[] parent) {
        if (parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);
    }

    public static void main(String[] args) {
        /*
         * Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner sc = new Scanner(System.in);

        List<Edge> edges = new ArrayList<>();

        int V = sc.nextInt();
        int E = sc.nextInt();

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            Edge e = new Edge(v1, v2, w);

            edges.add(e);
        }

        edges.sort((e1, e2) -> {
            return e1.w - e2.w;
        });

        List<Edge> mst = new ArrayList<>();

        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (Edge e : edges) {
            int v1 = e.v1;
            int v2 = e.v2;

            int p1 = findParent(v1, parent);
            int p2 = findParent(v2, parent);

            if (p1 != p2) {
                mst.add(e);
                parent[p1] = p2;
            }
        }

        for (Edge e : mst) {
            if (e.v1 < e.v2) {
                System.out.println(e.v1 + " " + e.v2 + " " + e.w);
            } else {
                System.out.println(e.v2 + " " + e.v1 + " " + e.w);
            }
        }

    }
}