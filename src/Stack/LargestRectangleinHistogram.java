package Stack;

import java.util.*;
import javafx.util.Pair;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
Input: heights = [2,4]
Output: 4
 */

public class LargestRectangleinHistogram {
    /*
    We use stack to keep track of heights and index of the rectangle
    Iterate through the list until you encounter element larger in stack then pop that element and calculate its area.check whether it is greater than previous area
    Then change start to popped element index.
    Push start and current height to start.If condition is not run then start will be current index
    after end of array calculate remaining elements in the array
     */
    public int largestRectangleArea(int[] heights) {
        if(heights==null){
            throw new IllegalArgumentException("Input array is null");
        }
        int n=heights.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return heights[0];
        }
        int maxArea=0,start;
        Stack<Pair<Integer,Integer>>stack=new Stack<Pair<Integer, Integer>>();
        for(int i=0;i<n;i++){
            start=i;
            int curHeight=heights[i];
            while(!stack.isEmpty() && stack.peek().getValue()>curHeight){
                Pair<Integer,Integer>pair=stack.pop();
                int index=pair.getKey();
                int height=pair.getValue();
                maxArea=Math.max(maxArea,height*(i-index));
                start=index;
            }
            stack.push(new Pair<>(start,curHeight));
        }
        while(!stack.isEmpty()){
            Pair<Integer,Integer>pair=stack.pop();
            int index=pair.getKey();
            int height=pair.getValue();
            maxArea=Math.max(maxArea,height*(n-index));
        }
        return maxArea;
    }
}
