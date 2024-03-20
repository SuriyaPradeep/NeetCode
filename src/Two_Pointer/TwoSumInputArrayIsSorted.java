package Two_Pointer;
/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSumInputArrayIsSorted {
    /*
    We can solve this using two pointer method.
    Initialize two pointers lo and hi pointing to starting and ending of the array respectively.
    Iterate through the array until lo<hi.
    Calculate the sum of lo and hi pointing number.Compare it with target.
    If sum>target reduce hi.
    If sum<target increase lo.
    If sum==target return lo and hi.
    Time Complexity:O(N)
    Space Complexity:O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int lo=0,hi=numbers.length-1;
        while(lo<hi){
            int sum=numbers[lo]+numbers[hi];
            if(sum<target){
                lo++;
            }else if(sum>target){
                hi--;
            }else{
                return new int[]{lo+1,hi+1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
