package Linked_List;
/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
public class ReverseNodesinKGroup {
    /*
It starts by traversing the list, counting nodes until it either reaches the end of the list or counts 'k' nodes.
If it counts 'k' nodes, it recursively calls the same function to reverse the next group of 'k' nodes.
After the recursion, it reverses the current group of 'k' nodes by adjusting the pointers.
Finally, it updates the head pointer to the last node of the reversed group and returns it.
     */
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode curr=head;
        int count=0;
        while(curr!=null && count<k){
            curr=curr.next;
            count++;
        }
        if(count==k){
            curr=reverseKGroup(curr,k);
            while(count-->0){
                ListNode temp=head.next;
                head.next=curr;
                curr=head;
                head=temp;
            }
            head=curr;
        }
        return head;
    }
}
