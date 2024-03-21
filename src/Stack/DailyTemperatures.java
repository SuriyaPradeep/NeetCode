package Stack;
import java.util.*;
/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */
public class DailyTemperatures {
    /*
    Initialize a stack for integers containing indexes of the array
    Iterate through the array add indexes to the stack
    while stack is not empty and temperatures[i]>stack.peek i.e. top element in stack
    then ans[index]=i-index where index is the top element in array pop the element from stack
    Time Complexity:O(N)
    Space Complexity:O(N)
     */
    public int[] dailyTemperaturesStack(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int n=temperatures.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index=stack.pop();
                ans[index]=i-index;
            }
            stack.push(i);
        }
        return ans;
    }
    /*
    Solve this problem faster and without use of the stack
    here we iterate through the array from end to start
    Initialize last element as the highest
    Iterate through the array if current temp is greater than highest element then make it highest
    else j-i+1 while temp[j]<=temp increase j=ans[j]+j then ans[i]=j-i
    Time Complexity:O(N)
    Space Complexity:O(1)
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length,highest=temperatures[n-1];
        int[] ans=new int[n];
        for(int i=n-2;i>=0;i--){
            int temp=temperatures[i];
            if(temp>=highest){
                highest=temp;
            }else{
                int j=i+1;
                while(temperatures[j]<=temp){
                    j=ans[j]+j;
                }
                ans[i]=j-i;
            }
        }
        return ans;
    }
}
