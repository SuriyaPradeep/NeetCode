package Sliding_Window;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:
Input: nums = [1], k = 1
Output: [1]
 */
public class SlidingWindowMaximum {
    /*
This Java solution implements the sliding window maximum problem using a deque (double-ended queue). Here's a brief explanation:
The method maxSlidingWindow takes an array of integers nums and an integer k representing the size of the sliding window.
It initializes an array res to store the maximum values in each sliding window.
It initializes a deque to store indices of elements within the current window.
The method iterates through the array using two pointers left and right.
At each iteration:
It removes indices from the deque that are outside the current window.
It removes indices of elements smaller than the current element from the back of the deque.
It adds the current index to the deque.
If the current index has moved beyond the first window (right >= k - 1), it records the maximum value in the window by accessing nums[deque.peek()] and stores it in res.
Finally, it returns the resulting array res containing the maximum values for each sliding window of size k.

     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<=0){
            return new int[0];
        }
        int n= nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for(int left=0,right=0;right<n;right++){
            while(!deque.isEmpty() && deque.peek()<right-k+1){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[right]>nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(right);
            if(right>=k-1){
                res[left++]=nums[deque.peek()];
            }
        }
        return res;
    }
}
