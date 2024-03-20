package Two_Pointer;
import java.util.*;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {
    /*
    We will start by initializing a set to store our indices as duplicates are not allowed.
    Let's sort the array as we will implement similar method to two pointers.
    Let's iterate through the array.
    First Loop i=0 runs till array.length-3 && nums[i]<=0.
    Second loop similar to two pointer sorted array left<right.Here left=i+1,right-n-1.
    if sum>0 decrease right sum<0 increase left if sum=0 add i,left,right to the list and increase left.
    Time Complexity:O(N^2)
    Space Complexity:O(N)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> indices = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3 && nums[i] <= 0;){
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    indices.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }else if (sum > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }
            i++;
            while(i < nums.length - 2 && nums[i] == nums[i - 1]){
                i++;
            }
        }
        return new ArrayList<>(indices);
    }
}
