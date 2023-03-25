/*
You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Input Format :
The first line of input contains an integer 'N' representing 
the dimension of the maze.
The next N lines of input contain N space-separated 
integers representing the type of the cell.

Output Format :
For each test case, print the path from start position to destination position and only cells that are part of the solution path should be 1, rest all cells should be 0.
Output for every test case will be printed in a separate line.

Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec

Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format.
*/

/*
	Note:
	To get all the test cases accepted, make recursive calls in following order: Top, Down, Left, Right.
	This means that if the current cell is (x, y), then order of calls should be: top cell (x-1, y), 
	down cell (x+1, y), left cell (x, y-1) and right cell (x, y+1).
*/


public class Solution {

    public static void ratInAMaze(int maze[][], int n, int x, int y, int[][] path) {
        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(path[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (x < 0 || x >= n || y < 0 || y >= n || maze[x][y] == 0 || path[x][y] == 1) {
            return;
        }
        path[x][y] = 1;
        ratInAMaze(maze, n, x - 1, y, path);
        ratInAMaze(maze, n, x + 1, y, path);
        ratInAMaze(maze, n, x, y - 1, path);
        ratInAMaze(maze, n, x, y + 1, path);
        path[x][y] = 0;
    }

    static void ratInAMaze(int maze[][], int n) {
        /*
         * Your class should be named Solution.
         * Write your code here
         */
        int[][] path = new int[n][n];
        ratInAMaze(maze, n, 0, 0, path);
    }

}