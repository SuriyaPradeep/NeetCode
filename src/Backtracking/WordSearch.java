package Backtracking;
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */
public class WordSearch {
    /*
exist(char[][] board, String word):
    This method iterates through each cell of the board and checks if the check method returns true for any starting position (i, j).
    If check returns true for any starting position, it means the word exists on the board, so it returns true.
    If check returns false for all starting positions, it means the word doesn't exist on the board, so it returns false.
check(char[][] board, String word, int i, int j, int m, int n, int cur):
    This method recursively checks whether the given word can be formed starting from the cell (i, j) on the board.
The base cases are:
    If cur (the current index in the word) exceeds or equals the length of the word, it means the entire word has been matched, so it returns true.
    If (i, j) is out of bounds or doesn't match the current character of the word, it returns false.
    The method then explores all four adjacent cells (up, down, left, right) from the current cell (i, j).
    For each adjacent cell, if it matches the next character of the word, it recursively calls check with the updated position and increments the cur index.
    It marks the current cell as visited by adding 100 to its value before recursion, and reverts it back to its original value after recursion.
    It returns true if any of the recursive calls return true, indicating that a valid path was found, otherwise it returns false.
     */
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check(board,word,i,j,m,n,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board,String word,int i,int j,int m,int n,int cur){
        if(cur>=word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(cur)){
            return false;
        }
        boolean exist=false;
        if(board[i][j]==word.charAt(cur)){
            board[i][j]+=100;
            exist=check(board,word,i+1,j,m,n,cur+1) || check(board,word,i-1,j,m,n,cur+1) || check(board,word,i,j+1,m,n,cur+1) || check(board,word,i,j-1,m,n,cur+1);
            board[i][j]-=100;
        }
        return exist;
    }
}
