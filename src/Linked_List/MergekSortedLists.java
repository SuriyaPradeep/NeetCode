package Linked_List;

import java.util.ListIterator;
import java.util.PriorityQueue;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []
 */
public class MergekSortedLists {
    //Using Priority Queue
    private class Solution1{
        /*
Initialize a min heap (PriorityQueue) with a custom comparator that compares ListNode objects based on their val attribute.
Iterate through the input array lists, and for each non-null list, insert its head node into the min heap.
Initialize a dummy node and a pointer curr to it.
While the min heap is not empty:
Pop the node with the minimum value from the min heap.
Append this node to the curr.next.
Update curr to the newly appended node.
If the popped node has a next node, insert this next node into the min heap.
Return the dummy.next, which is the head of the merged sorted linked list.
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }
            PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
            for(ListNode node:lists){
                if(node!=null){
                    pq.offer(node);
                }
            }
            ListNode dummy=new ListNode(0),curr=dummy;
            while(!pq.isEmpty()){
                ListNode node=pq.poll();
                curr.next=node;
                curr=curr.next;
                if(node.next!=null){
                    pq.offer(node.next);
                }
            }
            return dummy.next;
        }
    }
    //Merge Sort
    private class Solution2{
        /*
It first checks if the input array lists is null or empty. If so, it returns null.
It initializes variables size with the length of the input array lists and interval with 1.
It iterates while interval is less than size.
Within the loop, it iterates over the lists in intervals and merges pairs of lists together.
It doubles the interval at each iteration.
Finally, it returns the first list in the array, which is the merged result.

The merge method takes two sorted lists as input and merges them into a single sorted list.
It iterates through both lists simultaneously, comparing the values of the current nodes and appending the smaller one to the merged list.
Once one of the lists is exhausted, it appends the remaining nodes of the other list. Finally, it returns the merged list.
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }
            int size=lists.length,interval=1;
            while(interval<size){
                for(int i=interval;i<size-interval;i*=2){
                    lists[i]=merge(lists[i],lists[i + interval]);
                }
                interval*=2;
            }
            return lists[0];
        }
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy=new ListNode(0),curr=dummy;
            while(l1!=null && l2!=null){
                if(l1.val<=l2.val){
                    curr.next=l1;
                    l1=l1.next;
                }else{
                    curr.next=l2;
                    l2=l2.next;
                }
                curr=curr.next;
            }
            if (l1 != null) {
                curr.next=l1;
            } else {
                curr.next=l2;
            }
            return dummy.next;
        }
    }
}
/*
PriorityQueue Approach (First Method):
The mergeKLists method uses a PriorityQueue (min heap) to merge the lists. It iteratively pops the smallest element from the heap and appends it to the result list. This method has a time complexity of O(N log k), where N is the total number of elements in all lists and k is the number of lists.
This approach is efficient and straightforward, especially for a large number of lists or when the lists are long. It provides a balanced time complexity without much complexity in the implementation.

Divide and Conquer Approach (Second Method):
The mergeKLists method uses a divide-and-conquer approach. It repeatedly merges pairs of lists until only one list remains. This method has a time complexity of O(N log k), similar to the PriorityQueue approach.
This approach can be efficient but may involve more complex logic and coding compared to the PriorityQueue approach. It's suitable when the number of lists is relatively small and the lists are not too long.

Comparison:
The PriorityQueue approach may perform better in terms of simplicity and ease of implementation. It's particularly effective when dealing with a large number of lists or long lists.
The divide-and-conquer approach can also be efficient but may require more effort to implement and may be more suitable for smaller datasets or when you want to explore different algorithms.
 */
