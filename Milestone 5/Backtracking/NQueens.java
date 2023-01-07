/*
 * You are given N, and for a given N x N chessboard, find a way to place N
 * queens such that no queen can attack any other queen on the chess board. A
 * queen can be killed when it lies in the same row, or same column, or the same
 * diagonal of any of the other queens. You have to print all such
 * configurations.
 * 
 * Input Format :
 * Line 1 : Integer N
 * 
 * Output Format :
 * One Line for every board configuration.
 * Every line will have N*N board elements printed row wise and are separated by
 * space
 * 
 * Note : Don't print anything if there isn't any valid configuration.
 * 
 * Constraints :
 * 1<=N<=10
 * 
 * Sample Input 1:
 * 4
 * Sample Output 1 :
 * 0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
 * 0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0
 */

public class Solution {

    private static boolean isSafe(int[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 1) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Upper Left
        int r = row;
        for (int c = column; c >= 0; c--) {
            if (r >= 0) {
                if (board[r][c] == 1) {
                    return false;
                }
                r--;
            }
        }

        // Upper Right
        r = row;
        for (int c = column; c < board.length; c++) {
            if (r >= 0) {
                if (board[r][c] == 1) {
                    return false;
                }
                r--;
            }
        }

        // Lower Left
        r = row;
        for (int c = column; c >= 0; c--) {
            if (r < board.length - 1) {
                if (board[r][c] == 1) {
                    return false;
                }
                r++;
            }
        }

        // Lower Right
        r = row;
        for (int c = column; c < board.length; c++) {
            if (r < board.length - 1) {
                if (board[r][c] == 1) {
                    return false;
                }
                r++;
            }
        }

        return true;
    }

    private static void placeNQueens(int[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, row, column)) {
                board[row][column] = 1;
                placeNQueens(board, row + 1);
                board[row][column] = 0;
            }
        }
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void placeNQueens(int n) {

        /*
         * Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][] board = new int[n][n];
        placeNQueens(board, 0);
    }
}
