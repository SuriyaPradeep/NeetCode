package Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 */
public class WordSearchII {
    class Solution1{
        /*
Node class:
    This class represents a node in the Trie-like structure.
Each node contains:
    word: The complete word formed until this node, if any.
    child: A HashMap mapping characters to child nodes.
buildTree(String[] words) method:
    This method builds the Trie-like structure using the given array of words.
    It iterates through each word and inserts its characters into the Trie.
    After inserting all characters of a word, it sets the word attribute of the last node of the word to the word itself.
dfs(char[][] board, Node curr, HashSet<String> res, int i, int j, int m, int n) method:
    This method performs depth-first search (DFS) traversal on the board starting from a given position (i, j) and node curr in the Trie.
    It recursively explores adjacent cells of the board while traversing the Trie nodes.
    Whenever a word is found (i.e., a node with a non-null word attribute), it adds the word to the result set res.
    It marks visited cells on the board with '#' character to avoid revisiting them.
    After exploring all possible paths from the current cell, it restores the original character of the cell.
findWords(char[][] board, String[] words) method:
    This method initializes the Trie structure using the buildTree method.
    It iterates through each cell of the board and calls the dfs method to search for words starting from that cell.
    It returns the list of words found in the board.
         */
        class Node{
            private String word;
            private HashMap<Character,Node> child;
            public Node(){
                this.word=null;
                this.child=new HashMap<>();
            }
        }
        public Node buildTree(String[] words){
            Node root=new Node();
            for(String word:words){
                Node curr=root;
                for(char c:word.toCharArray()){
                    if(!curr.child.containsKey(c)){
                        curr.child.put(c,new Node());
                    }
                    curr=curr.child.get(c);
                }
                curr.word=word;
            }
            return root;
        }
        public void dfs(char[][] board, Node curr,HashSet<String> res, int i, int j, int m, int n){
            if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='#' || curr.child.get(board[i][j])==null){
                return;
            }
            if(curr.child.get(board[i][j]).word!=null){
                res.add(curr.child.get(board[i][j]).word);
            }
            curr=curr.child.get(board[i][j]);
            char c=board[i][j];
            board[i][j]='#';
            dfs(board,curr,res,i+1,j,m,n);
            dfs(board,curr,res,i-1,j,m,n);
            dfs(board,curr,res,i,j+1,m,n);
            dfs(board,curr,res,i,j-1,m,n);
            board[i][j]=c;
        }
        public List<String> findWords(char[][] board, String[] words) {
            Node root=buildTree(words);
            HashSet<String>res=new HashSet<>();
            int m=board.length,n=board[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dfs(board,root,res,i,j,m,n);
                }
            }
            return new ArrayList<>(res);
        }
    }
    class Solution2 {
        /*
Node class:
    This class represents a node in the Trie-like structure.
Each node contains:
    word: The complete word formed until this node, if any.
    child: An array of child nodes, where each index represents a character ('a' to 'z').
buildTree(String[] words) method:
    This method builds the Trie-like structure using the given array of words.
    It iterates through each word and inserts its characters into the Trie.
    After inserting all characters of a word, it sets the word attribute of the last node of the word to the word itself.
dfs(char[][] board, Node curr, HashSet<String> res, int i, int j, int m, int n) method:
    This method performs depth-first search (DFS) traversal on the board starting from a given position (i, j) and node curr in the Trie.
    It recursively explores adjacent cells of the board while traversing the Trie nodes.
    Whenever a word is found (i.e., a node with a non-null word attribute), it adds the word to the result set res.
    It marks visited cells on the board with '#' character to avoid revisiting them.
    After exploring all possible paths from the current cell, it restores the original character of the cell.
findWords(char[][] board, String[] words) method:
    This method initializes the Trie structure using the buildTree method.
    It iterates through each cell of the board and calls the dfs method to search for words starting from that cell.
    It returns the list of words found in the board.
         */
        class Node{
            private String word;
            private Node[] child;
            public Node(){
                this.word=null;
                this.child=new Node[26];
            }
        }
        public List<String> findWords(char[][] board, String[] words) {
            Node root=buildTree(words);
            HashSet<String>res=new HashSet<>();
            int m=board.length,n=board[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dfs(board,root,res,i,j,m,n);
                }
            }
            return new ArrayList<>(res);
        }
        public void dfs(char[][] board,Node curr,HashSet<String> res,int i,int j,int m,int n){
            if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='#' || curr.child[board[i][j]-'a']==null){
                return;
            }
            if(curr.child[board[i][j]-'a'].word!=null){
                res.add(curr.child[board[i][j]-'a'].word);
            }
            curr=curr.child[board[i][j] - 'a'];
            char c=board[i][j];
            board[i][j]='#';
            dfs(board,curr,res,i-1,j,m,n);
            dfs(board,curr,res,i+1,j,m,n);
            dfs(board,curr,res,i,j-1,m,n);
            dfs(board,curr,res,i,j+1,m,n);
            board[i][j]=c;
        }
        public Node buildTree(String[] words){
            Node root=new Node();
            for(String word:words){
                Node curr=root;
                for(char c:word.toCharArray()){
                    if(curr.child[c-'a']==null){
                        curr.child[c-'a']=new Node();
                    }
                    curr=curr.child[c - 'a'];
                }
                curr.word=word;
            }
            return root;
        }
    }
}
