package Linked_List;
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */
public class RemoveNthNodeFromEndofList {
    /*
Initialization: 
Create a dummy node to handle edge cases.
Initialize fast and slow pointers to the dummy node.
Moving fast pointer:
Move fast pointer ahead by n+1 steps.
Moving both pointers:
Iterate both fast and slow pointers until fast reaches the end.
Identifying target node:
At this point, slow points to the node before the target node to be removed.
Removing the node:
Update slow.next to skip the target node.
Return:
Return dummy.next, which is the head of the modified list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        ListNode fast=dummy,slow=dummy;
        dummy.next=head;
        for(int i=0;i<n+1;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
