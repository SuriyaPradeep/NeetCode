package Binary_Search;
/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */
public class BinarySearch {
    /*
    Implementing binary search.
    take two pointer pointing to first and last element in array.
    iterate through array while left<=right
    take mid of left and right and compare it with target
    if mid value is less than target increase left to mid+1
    if mid value is greater than target then decrease right to mid-1
    else return mid
    If target is not found after complete iterations then return -1
    Time Complexity:O(LogN)
     */
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
