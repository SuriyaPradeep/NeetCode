package Stack;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class MinStack {
    /*
    We will be implementing min stack using linked list
    Define a private class node which contains value,minimum value in stack and next node
    Construct a min stack where each node stores value for minimum value in stack so it can return min value in O(1)
    Time Complexity:-
    Push:O(N)
    Pop:O(N)
    Top:O(N)
    Min:O(N)

    Space Complexity:O(N)
     */
    private class Node{
        private int value;
        private int min;
        private Node next;

        public Node(int value,int min,Node next){
            this.value=value;
            this.min=min;
            this.next=next;
        }
    }
    Node head;
    public void push(int val) {
        if(head==null){
            head=new Node(val,val,null);
        }else{
            head=new Node(val,Math.min(val,head.min),head);
        }
    }
    public void pop() {
        head=head.next;
    }
    public int top() {
        return head.value;
    }
    public int getMin() {
        return head.min;
    }
}
