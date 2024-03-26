package Linked_List;
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:
Input: head = [1,2]
Output: [2,1]
Example 3:
Input: head = []
Output: []
 */
public class ReverseLinkedList {
    /*
It initializes a prev pointer to null, which will eventually point to the new head of the reversed list.
It iterates through the original list using a while loop, with a pointer head traversing each node.
Inside the loop:
It stores the next node of the current node head in a variable next to prevent losing the rest of the original list.
It then sets the next pointer of the current node head to point to the previous node prev, effectively reversing the link.
It updates the prev pointer to the current node head.
It moves the head pointer to the next node (head = next), advancing the iteration to the next node in the original list.
Once the loop completes, it returns the prev pointer, which now points to the head of the reversed list.
This method effectively reverses the links between nodes in the original list, resulting in the reversal of the entire list. Finally, it returns the new head of the reversed list.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while (head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
