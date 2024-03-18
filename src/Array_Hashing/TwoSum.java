package Array_Hashing;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */
public class TwoSum {
    /*
    To return index of two elements in array that add up to target value.
    Here we use a hashmap to store a number and its index.
    loop through the array and find its complement i.e. target-number.
    if the complement is already there in the hashmap return get the index of the number.
    return complement's index and current number's index.
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(hash.containsKey(complement)){
                return new int[]{hash.get(complement),i};
            }
            hash.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
