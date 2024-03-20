package Two_Pointer;
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:
Input: height = [1,1]
Output: 1
 */
public class ContainerWithMostWater {
    /*
    Initialize two pointer left and right pointing to starting and ending numbers in the array.
    Iterate while(left<right)
    find minimum value of left and right pointer as consider that as height.
    find distance between left and right i.e. right-left.
    find area by multiplying distance and height.Check current height or previous height is maximum and consider the largest one.
    check whether both pointers value are greater than height if not increase left and decrease for right.
    Time Complexity:O(N)
    Space Complexity:O(1)
     */
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int area=0;
        while(left<right){
            int distance=right-left,h=Math.min(height[left],height[right]);
            int curArea=distance*h;
            area=Math.max(area,curArea);
            while((height[left]<=h) && left<right){
                left++;
            }
            while((height[right]<=h) && left<right){
                right--;
            }
        }
        return area;
    }
}
