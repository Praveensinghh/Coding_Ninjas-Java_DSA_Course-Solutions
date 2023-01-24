/*
It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?

Input Format :
The first line of input contains an integer, that denotes the value of N. 
Each of the following N lines contain N space separated integers.

Output Format :
Print the count of '1's in the biggest piece of '1's, according to the description in the task.

Constraints :
1 <= N <= 1000
Time Limit: 1 sec

Sample Input 1:
2
1 1
0 1
Sample Output 1:
3
*/

public class Solution {

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private static int dfs(String[] edge, int i, int j, int[][] visited) {
        visited[i][j] = 1;
        int count = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < edge.length && y >= 0 && y < edge.length && edge[x].charAt(y) == '1'
                    && visited[x][y] == 0) {
                count += dfs(edge, x, y, visited);
            }
        }
        return count;
    }

    public static int dfs(String[] edge, int n) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int[][] visited = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edge[i].charAt(j) == '1' && visited[i][j] == 0) {
                    int count = dfs(edge, i, j, visited);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }
}