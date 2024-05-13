package Backtracking;

import java.util.ArrayList;
import java.util.List;
/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]
 */
public class Permutations {
    /*
swap(int[] nums, int i, int j):
    This method swaps the elements at indices i and j in the input array nums. It's used to generate permutations by swapping elements during backtracking.
backtrack(List<List<Integer>> ans, int[] nums, int start):
    This method recursively generates permutations of the input array nums starting from the index start. It iterates through all elements from start to the end of the array, swapping each element with the element at index start, then recursively generating permutations for the rest of the array. After the recursive call, it swaps the elements back to backtrack and explore other permutations.
permute(int[] nums):
    This is the entry point for generating permutations. It initializes an empty list ans to store all permutations and calls the backtrack method to start generating permutations from the beginning of the input array nums.
     */
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void backtrack(List<List<Integer>>ans,int[] nums,int start){
        if(start==nums.length){
            List<Integer>list=new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,i,start);
            backtrack(ans,nums,start+1);
            swap(nums,i,start);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(ans,nums,0);
        return ans;
    }
}
