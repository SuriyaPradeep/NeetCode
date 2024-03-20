package Two_Pointer;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class TrappingRainWater {
    /*
Initialization: Two pointers, left and right, are initialized to point to the beginning and end of the height array, respectively. Additionally, two variables leftMax and rightMax are initialized to store the maximum height encountered from the left and right sides, respectively.
Iterative Traversal: The algorithm iterates through the array using the two pointers left and right, moving them towards each other until they meet. This ensures that every bar in the histogram is considered.
Determining the Lower Side: At each step, the algorithm compares the heights of the bars pointed to by left and right. The lower side among the two (leftMax and rightMax) determines the amount of water that can be trapped at that position. This is because the maximum height encountered on the opposite side represents the maximum height the water can rise to.
Updating Maximum Heights: If the height of the current bar (height[left] or height[right]) is greater than the corresponding maximum height (leftMax or rightMax), the maximum height is updated accordingly. This ensures that the maximum height encountered so far is always stored.
Calculating Trapped Water: If the height of the current bar is less than or equal to the corresponding maximum height, it means that water can be trapped at that position. The amount of water that can be trapped is determined by the difference between the maximum height and the height of the current bar. This difference is added to the water variable.
Moving Pointers: Depending on which side has the lower maximum height (leftMax or rightMax), the corresponding pointer (left or right) is moved towards the opposite direction. This continues until the pointers meet.
Return Result: Once the pointers meet, the algorithm returns the total amount of trapped water stored in the water variable.
Time Complexity:O(N)
Space Complexity:O(1)
     */
    public int trap(int[] height) {
        int left=0,right=height.length-1,water=0;
        int leftMax=height[left],rightMax=height[right];
        while(left<right){
            if(leftMax<rightMax){
                left++;
                if(height[left]>leftMax){
                    leftMax=height[left];
                }else{
                    water+=leftMax-height[left];
                }
            }else{
                right--;
                if(height[right]>rightMax){
                    rightMax=height[right];
                }else{
                    water+=rightMax-height[right];
                }
            }
        }
        return water;
    }
}
