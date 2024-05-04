package Trees;
/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 */
public class SubtreeofAnotherTree {
    /*
public boolean isSubtree(TreeNode root, TreeNode subRoot): This method checks if subRoot is a subtree of root. It first checks if subRoot is null or if subRoot is the same as root using the sameTree method. If either condition is true, it returns true, indicating that subRoot is indeed a subtree of root. If root is null, it means we've reached the end of the tree and haven't found the subtree, so it returns false. Otherwise, it recursively searches for subRoot in the left and right subtrees of root.
public boolean sameTree(TreeNode p, TreeNode q): This method is similar to the one you provided earlier for checking if two trees are the same. It recursively compares nodes of the two trees p and q to check if they are identical in structure and value.
If both p and q are null, it returns true.
If one of p or q is null while the other is not, it returns false.
If the values of the current nodes p and q are not equal, it returns false.
Recursively, it checks the left and right subtrees of both trees by calling sameTree on their respective left and right children. The result of comparing the left and right subtrees must be true for both trees to be considered identical.
It returns true only if both left and right subtrees of p and q are identical.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null || sameTree(root,subRoot)){
            return true;
        }
        if(root==null){
            return false;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean sameTree(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left=sameTree(p.left,q.left);
        boolean right=sameTree(p.right,q.right);
        return left && right;
    }
}
