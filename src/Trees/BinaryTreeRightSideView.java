package Trees;
import java.util.*;
/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:
Input: root = [1,null,3]
Output: [1,3]
Example 3:
Input: root = []
Output: []
 */
public class BinaryTreeRightSideView {
    /*
public List<Integer> rightSideView(TreeNode root): This method takes the root of the binary tree as input and returns a list containing the values of nodes visible from the right side.
We initialize an empty list res to store the right side view result.
We create a queue queue using LinkedList to perform the breadth-first traversal of the binary tree.
If the root is null, indicating an empty tree, we immediately return the empty result list res.
We add the root node to the queue to start the traversal.
We enter a while loop that continues until the queue is empty. Inside the loop:
We get the current size of the queue, which represents the number of nodes at the current level.
We iterate over the nodes at the current level using a nested while loop.
In each iteration of the inner loop:
We dequeue a node curr from the queue.
If size is equal to 0, it means curr is the last node at the current level, so we add its value to the res list.
If curr has a left child, we enqueue the left child.
If curr has a right child, we enqueue the right child.
At the end of each outer loop iteration, size will decrease by 1 until all nodes at the current level are processed.
Finally, we return the result res, which contains the values of nodes visible from the right side of the binary tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                TreeNode curr=queue.poll();
                if(size==0){
                    res.add(curr.val);
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
        }
        return res;
    }
}
