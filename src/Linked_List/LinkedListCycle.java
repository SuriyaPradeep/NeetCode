package Linked_List;
/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {
    /*
Two pointers, fastPointer and slowPointer, are initialized to the head of the linked list.
In each iteration of the while loop, the fastPointer moves two steps forward, while the slowPointer moves one step forward.
If there's a cycle in the linked list, eventually, the fastPointer will meet the slowPointer.
If they meet, it means there's a cycle, and the function returns true.
If the fastPointer reaches the end of the list (fastPointer.next becomes null), it means there's no cycle, and the function returns false.
     */
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer=head,slowPointer=head;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if(slowPointer==fastPointer){
                return true;
            }
        }
        return false;
    }
}
