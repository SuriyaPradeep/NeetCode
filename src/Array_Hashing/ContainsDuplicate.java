package Array_Hashing;

import java.util.*;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class ContainsDuplicate {
    /*
    Here we will be using an set.Which will store the elements that are already visited.
    set.add return a boolean value true if the new element is added false if not added.
    Set will not add elements that are already present in the set.
    so if set.add() is false then return true.

    Time:O(N)
    Space:O(N)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

}
