/*
You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Input Format
Line 1: Integer N
Next N Lines: Each line will contain ith row elements (separated by space)

Output Format :
The output line contains true if any path exists for the rat to reach its destination otherwise print false.

Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true

Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
false
*/

public class Solution {

    private static boolean isSafe(int maze[][], int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1) {
            return true;
        }
        return false;
    }

    private static boolean ratInAMaze(int maze[][], int x, int y, int solution[][]) {

        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            if (solution[x][y] == 1) {
                return false;
            }
            solution[x][y] = 1;

            if (ratInAMaze(maze, x + 1, y, solution)) {
                return true;
            }
            if (ratInAMaze(maze, x - 1, y, solution)) {
                return true;
            }
            if (ratInAMaze(maze, x, y + 1, solution)) {
                return true;
            }
            if (ratInAMaze(maze, x, y - 1, solution)) {
                return true;
            }

            solution[x][y] = 0;
            return false;
        }
        return false;
    }

    public static boolean ratInAMaze(int maze[][]) {

        /*
         * Your class should be named Solution.
         * Don't write main().
         * Don't take input, it is passed as function argument.
         * Don't print output.
         * Taking input and printing output is handled automatically.
         */

        int solution[][] = new int[maze.length][maze.length];
        return ratInAMaze(maze, 0, 0, solution);
    }
}
