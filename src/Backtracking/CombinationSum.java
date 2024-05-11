package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSum {
    /*
backtrack Method:
    Signature: public void backtrack(List<List<Integer>> ans, List<Integer> list, int[] candidates, int start, int target)
    This method is a recursive backtracking function that generates combinations of numbers from the candidates array to achieve the target sum.
    Parameters:
    ans: The list to store all generated combinations.
    list: The list to store the current combination being generated.
    candidates: The input array of candidate numbers.
    start: The index in the candidates array from which to start considering elements for the current combination.
    target: The remaining target sum to achieve.
    If target becomes 0, it means the current combination sums up to the target. Hence, the current list is added to the ans.
    If target becomes negative or start exceeds the length of candidates, it means we have exceeded the target sum or considered all elements, so the function returns.
    Otherwise, at each recursive call:
    The current element candidates[start] is added to the list.
    backtrack is recursively called with the updated target (reduced by the current element) and the same start index.
    The last element is removed from the list (backtracking), and backtrack is recursively called with the next index start + 1 and the original target.
combinationSum Method:
    Signature: public List<List<Integer>> combinationSum(int[] candidates, int target)
    This method initializes the necessary data structures and then calls the backtrack method to generate combinations starting from index 0.
    Parameters:
    candidates: The input array of candidate numbers.
    target: The target sum to achieve.
    It returns the list of generated combinations after calling the backtrack method.
     */
    public void backtrack(List<List<Integer>> ans,List<Integer> list,int[] candidates,int start,int target){
        if(target==0){
            ans.add(new ArrayList<>(list));
        }else if(target<0 || start>= candidates.length){
            return;
        }else{
            list.add(candidates[start]);
            backtrack(ans,list,candidates,start,target-candidates[start]);
            list.remove(list.size()-1);
            backtrack(ans,list,candidates,start+1,target);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(ans,list,candidates,0,target);
        return ans;
    }
}
