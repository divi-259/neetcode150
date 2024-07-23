/*
Problem: Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Link: https://leetcode.com/problems/valid-sudoku/description/
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> hset = new HashSet<>();
        int m = board.length, n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(board[i][j]!='.') {
                    String row = board[i][j] + "row" + i;
                    String col = board[i][j] + "col" + j;
                    String block = board[i][j] + "block" + (i/3) +"-" + (j/3);
                    if(!hset.add(row) || !hset.add(col) || !hset.add(block))
                        return false;
                }

            }
        }
        return true;
    }
}