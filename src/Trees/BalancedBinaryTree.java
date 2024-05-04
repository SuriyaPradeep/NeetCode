package Trees;
/*
Given a binary tree, determine if it is height-balanced.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:
Input: root = []
Output: true
 */
public class BalancedBinaryTree {
    /*
public boolean isBalanced(TreeNode root): This method checks whether the binary tree rooted at root is balanced or not. If root is null, indicating an empty tree, it's considered balanced and the method returns true. Otherwise, it calls the Height method to compute the height of the tree and checks if the height is -1, which indicates that the tree is unbalanced. If so, it returns false, otherwise, it returns true.
public int Height(TreeNode root): This method calculates the height of the binary tree rooted at root. If root is null, it returns 0. Otherwise, it recursively calculates the height of the left and right subtrees. If either subtree has a height of -1, indicating it's unbalanced, the method returns -1, signifying that the entire tree is unbalanced. If the height difference between the left and right subtrees is greater than 1, the method also returns -1. Otherwise, it returns the height of the current node, which is 1 plus the maximum height of its left and right subtrees.
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Height(root)==-1){
            return false;
        }
        return true;
    }
    public int Height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Height(root.left);
        int right=Height(root.right);
        if(left==-1 || right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }
}
