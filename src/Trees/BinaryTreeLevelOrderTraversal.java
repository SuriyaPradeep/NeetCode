package Trees;

import java.util.*;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []
 */
public class BinaryTreeLevelOrderTraversal {
    /*
public List<List<Integer>> levelOrder(TreeNode root): This method takes the root of the binary tree as input and returns the level order traversal result as a list of lists of integers.
We initialize an empty list of lists res to store the level order traversal result.
We create a queue queue using LinkedList to perform the breadth-first traversal of the binary tree.
If the root is null, indicating an empty tree, we immediately return the empty result list res.
We add the root node to the queue to start the traversal.
We enter a while loop that continues until the queue is empty. Inside the loop:
We get the current size of the queue, which represents the number of nodes at the current level.
We initialize an empty list level to store the values of nodes at the current level.
We iterate size times to process all nodes at the current level. In each iteration:
We dequeue a node curr from the queue.
We add the value of the current node curr to the level list.
If the current node curr has a left child, we enqueue the left child.
If the current node curr has a right child, we enqueue the right child.
After processing all nodes at the current level, we add the level list to the result res.
Finally, we return the result res, which contains the level order traversal of the binary tree.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                level.add(curr.val);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
