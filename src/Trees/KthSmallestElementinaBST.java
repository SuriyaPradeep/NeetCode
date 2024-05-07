package Trees;

import java.util.*;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */
public class KthSmallestElementinaBST {
    /*
public int kthSmallest(TreeNode root, int k): This method takes the root of the BST and the value of k as input and returns the kth smallest element in the BST.
It initializes an ArrayList named res to store the elements of the BST in ascending order.
It performs an in-order traversal of the BST by calling the inorder method, passing the root of the BST and the res ArrayList as parameters.
Once the in-order traversal is complete, the kth smallest element is located at index k - 1 in the res ArrayList, because the ArrayList is 0-indexed.
It returns the value of the element located at index k - 1 in the res ArrayList.
public void inorder(TreeNode root, List<Integer> res): This recursive helper method performs an in-order traversal of the BST.
If root is null, indicating an empty tree or a leaf node, it returns.
It recursively calls the inorder method on the left subtree to visit all nodes in the left subtree in ascending order.
It adds the value of the current node root to the res ArrayList.
It recursively calls the inorder method on the right subtree to visit all nodes in the right subtree in ascending order.
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer>res=new ArrayList<>();
        inorder(root,res);
        return res.get(k-1);
    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
