package Linked_List;

public class MergeTwoSortedLists {
    /*
It initializes a dummy node res with a value of 0, which serves as the head of the merged list. It also initializes a pointer curNode to track the current node being processed.
It iterates through both lists simultaneously using a while loop, continuing until either list1 or list2 becomes null.
Inside the loop:
It compares the values of the current nodes in list1 and list2.
It appends the smaller value to the merged list by creating a new node with that value and attaching it to the next of the curNode. It then moves the pointer of the corresponding list (list1 or list2) to its next node.
It advances the curNode pointer to the newly added node in the merged list.
After the loop, it checks if there are any remaining nodes in list1 or list2. If so, it appends them to the merged list by creating new nodes with their values.
Finally, it returns the next of the dummy node res, which points to the head of the merged list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode(0),curNode=res;
        while (list1!=null && list2!=null){
            int val1=list1.val;
            int val2= list2.val;
            if(val1<=val2){
                curNode.next=new ListNode(val1);
                list1=list1.next;
            }else{
                curNode.next=new ListNode(val2);
                list2=list2.next;
            }
            curNode=curNode.next;
        }
        while (list1!=null){
            curNode.next=new ListNode(list1.val);
            list1=list1.next;
            curNode=curNode.next;
        }
        while (list2!=null){
            curNode.next=new ListNode(list2.val);
            list2=list2.next;
            curNode=curNode.next;
        }
        return res.next;
    }
}
