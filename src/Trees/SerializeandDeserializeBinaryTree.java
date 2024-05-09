package Trees;

import java.util.ArrayList;
import java.util.List;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:
Input: root = []
Output: []
 */
public class SerializeandDeserializeBinaryTree {
    /*
serialize(TreeNode root):
    This method serializes the binary tree starting from the root node.
    It initializes an empty list list to store the serialized tree elements.
    Then, it calls the serializeDFS method to perform a depth-first traversal of the tree, adding each node's value (or "N" for null nodes) to the list.
    Finally, it joins the elements of the list into a single string separated by commas and returns it.
serializeDFS(TreeNode root, List<String> list):
    This is a recursive helper method for serialization.
    If the current node is null, it adds "N" to the list to represent the null node.
    If the current node is not null, it adds the value of the node to the list, then recursively calls serializeDFS for its left and right children.
deserialize(String data):
    This method deserializes the serialized data string and reconstructs the original binary tree.
    It splits the input data string by commas to get an array of tokens.
    Then, it calls the deserializeDFS method with the array of tokens to reconstruct the tree.
deserializeDFS(String[] tokens):
    This is a recursive helper method for deserialization.
    It uses an index i to keep track of the current position in the token array.
    If the current token is "N", it means a null node, so it increments i and returns null.
    If the current token represents a valid node value, it creates a new TreeNode with that value.
    Then, it recursively calls deserializeDFS to construct its left and right children, and assigns them accordingly.
    Finally, it returns the constructed node.
     */
    private int i;
    public String serialize(TreeNode root) {
        List<String>list=new ArrayList<>();
        serializeDFS(root,list);
        return String.join(",",list);
    }
    public void serializeDFS(TreeNode root, List<String>list){
        if(root==null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeDFS(root.left,list);
        serializeDFS(root.right,list);
    }
    public TreeNode deserialize(String data) {
        String[] tokens=data.split(",");
        return deserializeDFS(tokens);
    }
    public TreeNode deserializeDFS(String[] tokens){
        if(tokens[this.i].equals("N")){
            this.i++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(tokens[this.i++]));
        node.left=deserializeDFS(tokens);
        node.right=deserializeDFS(tokens);
        return node;
    }
}
