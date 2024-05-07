package Trees;

public class ValidateBinarySearchTree {
    /*
public boolean isValidBST(TreeNode root): This method takes the root of the binary tree as input and returns true if the tree is a valid BST, otherwise returns false. It calls the dfs method to perform the recursive traversal.
public boolean dfs(TreeNode root, Integer min, Integer max): This recursive helper method traverses the binary tree and checks if the tree is a valid BST.
If root is null, indicating an empty tree or a leaf node, it returns true.
It checks if the value of the current node root is within the valid range defined by min and max. If min is not null and is greater than or equal to the current node's value, or if max is not null and is less than or equal to the current node's value, it returns false.
It recursively checks the left subtree of the current node by calling dfs(root.left, min, root.val). The valid range for nodes in the left subtree becomes [min, root.val), where root.val is the maximum value allowed for nodes in the left subtree.
It recursively checks the right subtree of the current node by calling dfs(root.right, root.val, max). The valid range for nodes in the right subtree becomes (root.val, max], where root.val is the minimum value allowed for nodes in the right subtree.
It returns true if both the left and right subtrees are valid BSTs according to the updated valid ranges.
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root,null,null);
    }
    public boolean dfs(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if((min!=null && min>= root.val)||(max!=null && max<= root.val)){
            return false;
        }
        return dfs(root.left,min,root.val)&&dfs(root.right,root.val,max);
    }
}
