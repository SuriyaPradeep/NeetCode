package Trees;

import java.util.Arrays;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    class Solution1{
        /*
public TreeNode buildTree(int[] preorder, int[] inorder): This method takes the preorder and inorder traversal arrays of a binary tree as input and returns the root of the constructed binary tree.
If either the preorder or inorder array is empty, it means there are no elements in the tree, so it returns null.
It initializes the root of the binary tree with the first element of the preorder array.
It searches for the index of the root node's value in the inorder array. This index splits the inorder array into left and right subtrees.
It constructs the left subtree recursively by calling buildTree with the appropriate subarrays of preorder and inorder.
It constructs the right subtree recursively by calling buildTree with the appropriate subarrays of preorder and inorder.
It returns the root of the constructed binary tree.
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length==0 || inorder.length==0){
                return null;
            }
            TreeNode root=new TreeNode(preorder[0]);
            int mid=0;
            for(int i=0;i<inorder.length;i++){
                if(preorder[0]==inorder[i]){
                    mid=i;
                    break;
                }
            }
            root.left=buildTree(Arrays.copyOfRange(preorder,1,mid+1),Arrays.copyOfRange(inorder,0,mid));
            root.right=buildTree(Arrays.copyOfRange(preorder,mid+1,preorder.length),Arrays.copyOfRange(inorder,mid+1,inorder.length));
            return root;
        }
    }
    class Solution2{
        /*
public TreeNode buildTree(int[] preorder, int[] inorder): This method takes the preorder and inorder traversal arrays of a binary tree as input and returns the root of the constructed binary tree.
It first checks if the lengths of the preorder and inorder arrays are not equal. If they are not equal, it means the input arrays are invalid, so it returns null.
Otherwise, it calls the build method with the appropriate parameters to construct the binary tree recursively.
public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd): This recursive helper method constructs the binary tree using the following parameters:
preStart: The starting index of the current subtree in the preorder array.
preEnd: The ending index of the current subtree in the preorder array.
inStart: The starting index of the current subtree in the inorder array.
inEnd: The ending index of the current subtree in the inorder array.
If preStart is greater than preEnd or inStart is greater than inEnd, it means the current subtree is empty, so it returns null.
It creates the root of the current subtree using the value at index preStart in the preorder array.
It finds the index of the root value in the inorder array, which splits the inorder array into left and right subtrees.
It calculates the length of the left subtree (leftTreeLen) by subtracting inStart from mid.
It recursively constructs the left subtree by calling build with updated parameters for the left subtree.
It recursively constructs the right subtree by calling build with updated parameters for the right subtree.
It returns the root of the current subtree.
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length!=inorder.length){
                return null;
            }
            return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        }
        public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
            if(preStart>preEnd || inStart>inEnd){
                return null;
            }
            TreeNode root=new TreeNode(preorder[preStart]);
            int mid=inStart;
            for(int i=inStart;i<=inEnd;i++){
                if(root.val==inorder[i]){
                    mid=i;
                    break;
                }
            }
            int leftTreeLen=mid-inStart;
            root.left=build(preorder,preStart+1,preStart+leftTreeLen,inorder,inStart,mid-1);
            root.right=build(preorder,preStart+leftTreeLen+1,preEnd,inorder,mid+1,inEnd);
            return root;
        }
    }
}
