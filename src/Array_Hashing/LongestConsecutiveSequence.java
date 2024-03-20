package Array_Hashing;

import java.util.*;
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */
public class LongestConsecutiveSequence {
    /*
    To find the longest Consecutive sequence.
    We will all the elements from array to a set.
    then again iterate through array.To find is there a sequence.
    Check if there is left side elements of the number in set till there is none.
    Do the same for right.
    Calculate length by right-left-1;
    Time:O(N)
    Space:O(N)
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int left=0,right=0,longest=0;
        for(int num:nums){
            left=num-1;
            right=num+1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            longest=Math.max(longest,right-left-1);
            if(set.isEmpty()){
                return longest;
            }
        }
        return longest;
    }
}
