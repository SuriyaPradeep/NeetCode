package Linked_List;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
 */
public class FindtheDuplicateNumber {
    /*
Initial Setup:
Two pointers, slow and fast, are initialized to the first element of the nums array.
Cycle Detection:
The code enters a loop to detect a cycle in the array.
slow moves one step at a time (nums[slow]), while fast moves two steps at a time (nums[nums[fast]]).
If there is a duplicate in the array, slow and fast will eventually meet inside the cycle.
Once a meeting point is detected (fast == slow), the loop is exited.
Finding the Start of the Cycle:
After detecting the meeting point, one pointer (slow2) is reset to the beginning of the array.
Another pointer (slow) remains at the meeting point.
Both pointers (slow and slow2) now move at the same pace (one step at a time).
The point where they meet is the start of the cycle (which corresponds to the duplicate element).
Returning the Duplicate:
Once the duplicate element is found, it is returned as the result.
     */
    public int findDuplicate(int[] nums) {
        int slow=nums[0],fast=nums[0];
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(fast==slow){
                break;
            }
        }
        int slow2=nums[0];
        while(slow!=slow2){
            slow=nums[slow];
            slow2=nums[slow2];
        }
        return slow;
    }
}
