package Trees;
/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:
Input: root = [1,2]
Output: 1
 */
public class DiameterofBinaryTree {
    /*
int result = -1;: This variable is declared outside of any method, making it accessible to both diameterOfBinaryTree and dfs methods. It will store the diameter of the binary tree.
public int diameterOfBinaryTree(TreeNode root): This method is the entry point for calculating the diameter of the binary tree. It initializes the diameter calculation by calling the dfs method and then returns the final result.
public int dfs(TreeNode root): This method is a helper function that performs a depth-first search traversal of the binary tree and calculates the depth of each node. It returns the depth of the current node and updates the result variable with the diameter found so far.
Inside the dfs method, there's a null check for the root node. If the root is null, it returns -1 as there are no nodes.
It recursively calculates the depth of the left and right subtrees using dfs. The depth of the current node is calculated as 1 plus the maximum depth of its left and right subtrees.
The diameter of the binary tree passing through the current node is calculated as the sum of the depths of its left and right subtrees.
The result variable is updated with the maximum diameter found so far.
Finally, the method returns the maximum depth of the current node.
     */
    int result=-1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return -1;
        }
        int left=1+dfs(root.left);
        int right=1+dfs(root.right);
        result=Math.max(result,(left+right));
        return Math.max(left,right);
    }
}
