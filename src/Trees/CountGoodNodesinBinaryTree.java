package Trees;
/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.
Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:
Input: root = [1]
Output: 1
Explanation: Root is considered as good.
 */
public class CountGoodNodesinBinaryTree {
    /*
public int goodNodes(TreeNode root): This method takes the root of the binary tree as input and returns the number of good nodes in the tree. It calls the helper method to perform the recursive traversal.
public int helper(TreeNode root, int max): This recursive helper method traverses the binary tree and calculates the number of good nodes.
If root is null, indicating an empty tree or a leaf node, it returns 0.
It initializes a variable res to 1 if the value of the current node root is greater than or equal to the maximum value encountered so far (max), otherwise, it initializes res to 0.
It recursively calculates the number of good nodes in the right subtree by calling helper(root.right, Math.max(root.val, max)). The maximum value encountered in the path from the root to the current node is updated to the maximum of the current node's value and the previous maximum (max).
Similarly, it recursively calculates the number of good nodes in the left subtree by calling helper(root.left, Math.max(root.val, max)).
It returns the sum of the number of good nodes in the current node's subtree and the number of good nodes in its left subtree and right subtree.
     */
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }
    public int helper(TreeNode root,int max){
        if(root==null){
            return 0;
        }
        int res=root.val>=max?1:0;
        res+=helper(root.right,Math.max(root.val,max));
        res+=helper(root.left,Math.max(root.val,max));
        return res;
    }
}