package Linked_List;
/*
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 */
public class ReorderList {
    /*
Find the middle of the list:
Use two pointers, fastPointer and slowPointer, to find the middle node of the list.
Reverse the second half of the list starting from the middle:
Iterate through the list from the middle to the end, reversing the pointers along the way.
Exchange values between the first and second half of the list:
Swap nodes between the original list and the reversed list, interlacing them to reorder the list.
Example with input list 1 -> 2 -> 3 -> 4 -> 5:
Middle: 3
Reversed second half: 3 -> 5 -> 4
Final reordered list: 1 -> 5 -> 2 -> 4 -> 3
     */
    public void reorderList(ListNode head) {
        //Find Middle
        ListNode fastPointer=head,slowPointer=head;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
        }
        //Reverse from middle
        ListNode prev=null,cur=slowPointer.next;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        ListNode head2=prev;
        slowPointer.next=null;
        //Exchange values
        while(head!=null && head2!=null){
            ListNode temp1=head.next;
            ListNode temp2=head2.next;
            head2.next=head.next;
            head.next=head2;
            head=temp1;
            head2=temp2;
        }
    }
}
