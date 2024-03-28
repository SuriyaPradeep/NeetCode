package Linked_List;

import java.util.HashMap;

/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 */
public class CopyListwithRandomPointer {
    /*
Node Class:
Represents a node in a linked list.
Each node contains three attributes: val (integer value), next (reference to the next node), and random (reference to a random node).
copyRandomList Method:
Accepts a parameter head, which is the head of the original linked list with random pointers.
Initializes a HashMap oldToNew to map nodes from the original list to their corresponding nodes in the copied list.
First Pass:
Iterates through the original list (head).
For each node encountered, creates a new node with the same value and puts it into the HashMap oldToNew, mapping the original node to the newly created node.
Second Pass:
Iterates through the original list again.
For each node encountered:
Sets the next pointer of the corresponding new node (in oldToNew) to the new node corresponding to the next of the current node.
Sets the random pointer of the corresponding new node (in oldToNew) to the new node corresponding to the random of the current node.
Returning Result:
Returns the head of the copied list, which is the value associated with the head key in the oldToNew HashMap.
     */
    private class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val=val;
            this.next=null;
            this.random=null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>oldToNew=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            oldToNew.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            oldToNew.get(curr).next=oldToNew.get(curr.next);
            oldToNew.get(curr).random=oldToNew.get(curr.random);
            curr=curr.next;
        }
        return oldToNew.get(head);
    }
}
