package Trees;
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2
 */
public class LowestCommonAncestorofaBinarySearchTree {
    /*
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q): This method takes the root of the BST and the two nodes p and q as input and returns their lowest common ancestor.
The method begins with a null check. If the root is null, it returns null because there's no node in the tree.
Then, it checks whether p and q both lie in the right subtree of the current node root. If both p and q have values greater than root.val, it means the LCA must be in the right subtree. So, it recursively calls the lowestCommonAncestor function on root.right.
Similarly, if both p and q have values less than root.val, it means the LCA must be in the left subtree. So, it recursively calls the lowestCommonAncestor function on root.left.
If neither of the above conditions is met, it means one node lies in the left subtree and the other lies in the right subtree, or one of them is equal to the current node root. In any case, the current node root is the lowest common ancestor, so it returns root.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
