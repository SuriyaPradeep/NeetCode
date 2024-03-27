package Linked_List;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
Initialize carryOn to 0, which will hold the carry when adding digits.
Create a dummy ListNode object to serve as the head of the result linked list. Initialize currNode to point to this dummy node.
Iterate through both input lists (l1 and l2) simultaneously until both of them are exhausted and there's no carry left.
Inside the loop:
Calculate the values to be added from the current nodes of l1 and l2, considering possible null values (if one list is shorter than the other).
Update l1 and l2 to move to the next nodes.
Calculate the sum of the current digits along with the carry from the previous iteration.
Update the carry for the next iteration and calculate the digit to be stored in the result.
Create a new ListNode with the calculated digit and attach it to the result linked list.
Move currNode to the next node in the result list.
Finally, return the next node of the dummy node, which effectively gives the head of the resultant linked list.
         */
        int carryOn=0;
        ListNode dummy=new ListNode(0),currNode=dummy;
        while(l1!=null||l2!=null||carryOn!=0){
            int val1=(l1==null)?0:l1.val;
            int val2=(l2==null)?0:l2.val;
            l1=(l1==null)?null:l1.next;
            l2=(l2==null)?null:l2.next;
            int sum=val1+val2+carryOn;
            carryOn=sum/10;
            sum=sum%10;
            currNode.next=new ListNode(sum);
            currNode=currNode.next;
        }
        return dummy.next;
    }
}
