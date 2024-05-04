package Trees;
/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
 */
public class SameTree {
    /*
public boolean isSameTree(TreeNode p, TreeNode q): This method is the entry point for checking whether two binary trees p and q are identical. It calls the dfs method with the root nodes of both trees p and q, and returns the result of the recursive comparison.
public boolean dfs(TreeNode p, TreeNode q): This method recursively compares nodes of the two trees p and q to check if they are identical.
If both p and q are null, it means they have reached the leaves and are identical, so it returns true.
If one of p or q is null while the other is not, it means the trees have different structures, so it returns false.
If the values of the current nodes p and q are not equal, the trees are not identical, so it returns false.
Recursively, it checks the left and right subtrees of both trees by calling dfs on their respective left and right children. The result of comparing the left and right subtrees must be true for both trees to be considered identical.
It returns true only if both left and right subtrees of p and q are identical.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    public boolean dfs(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left=dfs(p.left,q.left);
        boolean right=dfs(p.right,q.right);
        return left && right;
    }
}
