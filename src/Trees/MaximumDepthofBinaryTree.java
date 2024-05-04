package Trees;
/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:
Input: root = [1,null,2]
Output: 2
 */
public class MaximumDepthofBinaryTree {
    /*
The method begins with a null check. If the root node is null, indicating an empty tree or a leaf node, the method returns 0 because there are no levels in this case.
If the root node is not null, the method recursively calculates the maximum depth of the left and right subtrees using maxDepth. It then takes the maximum of these two depths using Math.max.
Since each level adds 1 to the depth, the method returns the maximum of the depths of the left and right subtrees plus 1, indicating the depth of the current node.
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
