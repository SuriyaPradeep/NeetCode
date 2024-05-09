package Tries;
/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 */
public class ImplementTrie_PrefixTree {
    /*
Node class:
    This inner class represents a node in the Trie.
    Each node contains:
    val: The character value stored in the node.
    isWord: A boolean flag indicating whether the node represents the end of a word.
    child: An array of child nodes, where each index represents a character ('a' to 'z').
Trie class:
    This class encapsulates the Trie data structure.
    It contains a single instance variable root, which is the root node of the Trie.
Constructor:
    The constructor initializes the Trie with an empty root node. The root node has a special character value '\0' (null character).
helper(String word) method:
    This private helper method traverses the Trie based on a given word.
    It returns the node corresponding to the last character of the word if it exists in the Trie, otherwise, it returns null.
insert(String word) method:
    This method inserts a word into the Trie.
    It traverses the Trie based on the characters of the word and creates nodes as needed.
    After traversing the Trie, it sets the isWord flag of the last node to true to indicate that it represents the end of a word.
search(String word) method:
    This method checks if a word exists in the Trie.
    It utilizes the helper method to find the node corresponding to the last character of the word.
    If the node exists and represents the end of a word (isWord is true), it returns true; otherwise, it returns false.
startsWith(String prefix) method:
    This method checks if any word in the Trie starts with a given prefix.
    It uses the helper method to find the node corresponding to the last character of the prefix.
    If the node exists, it means the prefix exists in the Trie, so the method returns true; otherwise, it returns false.
     */
    class Trie{
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
        public Trie(){
            root=new Node('\0');
        }
        public Node helper(String word){
            Node curr=root;
            for(char c:word.toCharArray()){
                if(curr.child[c-'a']==null){
                    return null;
                }
                curr=curr.child[c-'a'];
            }
            return curr;
        }
        public void insert(String word){
            Node curr=root;
            for(char c:word.toCharArray()){
                if(curr.child[c-'a']==null){
                    curr.child[c-'a']=new Node(c);
                }
                curr=curr.child[c-'a'];
            }
            curr.isWord=true;
        }
        public boolean search(String word){
            Node res=helper(word);
            return (res!=null && res.isWord);
        }
        public boolean startsWith(String prefix) {
            Node res=helper(prefix);
            return res!=null;
        }
    }
}
