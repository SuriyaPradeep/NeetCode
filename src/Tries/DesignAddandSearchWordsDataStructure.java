package Tries;

public class DesignAddandSearchWordsDataStructure {
    /*
Node class:
    This inner class represents a node in the WordDictionary Trie.
Each node contains:
    val: The character value stored in the node.
    isWord: A boolean flag indicating whether the node represents the end of a word.
    child: An array of child nodes, where each index represents a character ('a' to 'z').
Constructor:
    The constructor initializes the WordDictionary with an empty root node. The root node has a special character value '\0' (null character).
addWord(String word) method:
    This method adds a word to the WordDictionary.
    It traverses the WordDictionary based on the characters of the word and creates nodes as needed.
    After traversing the WordDictionary, it sets the isWord flag of the last node to true to indicate that it represents the end of a word.
helper(String word, Node curr, int index) method:
    This method is a helper function for the search operation, supporting wildcard searches.
    It recursively searches for a word in the WordDictionary starting from a given index.
    If the character is a '.', it iterates over all child nodes of the current node and recursively searches for the rest of the word.
    If the character is not a '.', it checks if the child node corresponding to the character exists and recursively searches further.
    It returns true if the word is found; otherwise, it returns false.
search(String word) method:
    This method searches for a word in the WordDictionary.
    It calls the helper method with the word to perform the search, starting from the root node.
     */
    class WordDictionary{
        class Node{
            private char val;
            private boolean isWord;
            private Node[] child;
            public Node(char val){
                this.val=val;
                this.isWord=false;
                this.child=new Node[26];
            }
        }
        Node root;
        public WordDictionary(){
            root=new Node('\0');
        }
        public void addWord(String word){
            Node curr=root;
                for(char c:word.toCharArray()){
                    if(curr.child[c-'a']==null){
                        curr.child[c-'a']=new Node(c);
                    }
                    curr=curr.child[c-'a'];
                }
            curr.isWord=true;
        }
        public boolean helper(String word,Node curr,int index){
            for(int i=index;i<word.length();i++){
                char c=word.charAt(i);
                if(c=='.'){
                    for(Node temp: curr.child){
                        if(temp!=null && helper(word,temp,i+1)){
                            return true;
                        }
                    }
                    return false;
                }
                if(curr.child[c-'a']==null){
                    return false;
                }
                curr=curr.child[c-'a'];
            }
            return curr.isWord;
        }
        public boolean search(String word){
            return helper(word,root,0);
        }
    }
}
