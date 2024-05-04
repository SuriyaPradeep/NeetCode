package Trees;
/*
Given the root of a binary tree, invert the tree, and return its root.
Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:
Input: root = []
Output: []
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        /*
The method begins with a null check. If the root node is null, indicating an empty tree or a leaf node, the method simply returns null, because there's no need to invert anything for a null node.
If the root node is not null, a new TreeNode called node is created with the same value as the root node. This is the beginning of the inversion process.
The right child of the node is assigned the result of recursively calling invertTree with the left child of the root. This effectively swaps the left and right subtrees of the current node in the inverted tree.
Similarly, the left child of the node is assigned the result of recursively calling invertTree with the right child of the root.
Finally, the method returns the node, which represents the root of the inverted subtree.
         */
        if(root==null){
            return null;
        }
        TreeNode node=new TreeNode(root.val);
        node.right=invertTree(root.left);
        node.left=invertTree(root.right);
        return node;
    }
}
