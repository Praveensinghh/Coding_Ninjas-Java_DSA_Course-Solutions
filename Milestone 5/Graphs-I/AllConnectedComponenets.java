/*
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two space separated integers, that denote that there exists an edge between vertex a and b.

Output Format :
Print different components in new line. And each component should be printed in increasing order of vertices (separated by space). Order of different components doesn't matter.

Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Sample Input 1:
4 2
0 1
2 3
Sample Output 1:
0 1 
2 3 

Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
0 1 3 
2
*/


import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Solution {

	private static void printConnectedComponents(int[][] edges, boolean[] visited, ArrayList<Integer> arrans, int sv) {
		Queue<Integer> pendingVertices = new LinkedList<Integer>();
		pendingVertices.add(sv);
		visited[sv] = true;
		while (!pendingVertices.isEmpty()) {
			int currentVertex = pendingVertices.poll();
			arrans.add(currentVertex);
			for (int i = 0; i < edges.length; i++) {
				if (edges[currentVertex][i] == 1 && !visited[i]) {
					pendingVertices.add(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void printConnectedComponents(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				ArrayList<Integer> answer = new ArrayList<Integer>();
				printConnectedComponents(edges, visited, answer, i);
				Collections.sort(answer);
				for (int j = 0; j < answer.size(); j++)
					System.out.print(answer.get(j) + " ");
				System.out.println();
			}
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

		int[][] edges = new int[v][v];

		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			edges[v1][v2] = 1;
			edges[v2][v1] = 1;
		}

		printConnectedComponents(edges);
	}
}