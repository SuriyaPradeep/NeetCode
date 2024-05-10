package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
 */
public class Subsets {
    /*
helper Method:
    Signature: public void helper(List<List<Integer>> ans, List<Integer> list, int start, int[] nums)
    This method is a recursive helper function responsible for generating subsets of the input array nums.
    Parameters:
    ans: The list to store all generated subsets.
    list: The list to store the current subset being generated.
    start: The index in the nums array from which to start considering elements for the current subset.
    nums: The input integer array.
    When start is greater than or equal to the length of nums, it means all elements have been considered for the current subset, so the current list is added to the ans.
    Otherwise, at each recursive call:
    The current element nums[start] is added to the list.
    helper is recursively called with start + 1 to explore including the current element in the subset.
    The last element is removed from the list (backtracking), and helper is recursively called with start + 1 to explore excluding the current element from the subset.
subsets Method:
    Signature: public List<List<Integer>> subsets(int[] nums)
    This method initializes the necessary data structures and then calls the helper method to generate subsets starting from index 0.
    Parameters:
    nums: The input integer array for which subsets are to be generated.
    It returns the list of generated subsets after calling the helper method.
     */
    public void helper(List<List<Integer>>ans,List<Integer>list,int start,int[] nums){
        if(start>=nums.length){
            ans.add(new ArrayList<>(list));
        }else{
            list.add(nums[start]);
            helper(ans,list,start+1,nums);
            list.remove(list.size()-1);
            helper(ans,list,start+1,nums);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        helper(ans,list,0,nums);
        System.out.println(ans);
        //[[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
        return ans;
    }
}
