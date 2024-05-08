package Trees;
/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.
Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class BinaryTreeMaximumPathSum {
    /*
public int maxPathSum(TreeNode root): This method takes the root of the binary tree as input and returns the maximum path sum in the tree.
It initializes an integer array res with a single element containing Integer.MIN_VALUE. This array is used to store the maximum path sum encountered during the traversal.
It calls the maxSum method to recursively calculate the maximum path sum.
After the traversal is complete, it returns the maximum path sum stored in res[0].
public int maxSum(TreeNode root, int[] res): This recursive helper method calculates the maximum path sum starting from the current node root and updates the maximum path sum stored in res[0].
If root is null, indicating an empty tree or a leaf node, it returns 0.
It recursively calculates the maximum path sum for the left subtree by calling maxSum(root.left, res). If the sum obtained from the left subtree is negative, it is considered as 0.
It recursively calculates the maximum path sum for the right subtree by calling maxSum(root.right, res). If the sum obtained from the right subtree is negative, it is considered as 0.
It calculates the sum of the current node's value, the maximum sum obtained from the left subtree (left), and the maximum sum obtained from the right subtree (right). This sum represents the maximum path sum passing through the current node.
It updates the maximum path sum stored in res[0] by taking the maximum of the current sum and the value stored in res[0].
It returns the sum of the current node's value and the maximum of the sums obtained from the left and right subtrees. This represents the maximum path sum starting from the current node.
     */
    public int maxPathSum(TreeNode root) {
        int[] res={Integer.MIN_VALUE};
        maxSum(root,res);
        return res[0];
    }
    public int maxSum(TreeNode root,int[] res){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,maxSum(root.left,res));
        int right=Math.max(0,maxSum(root.right,res));
        res[0]=Math.max(res[0], root.val+left+right);
        return root.val+Math.max(left,right);
    }

}
