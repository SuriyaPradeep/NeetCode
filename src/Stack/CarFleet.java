package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
There are n cars going to the same destination along a one-lane road. The destination is target miles away.

You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).

A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).
A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
Return the number of car fleets that will arrive at the destination.
Example 1:
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Note that no other cars meet these fleets before the destination, so the answer is 3.
Example 2:
Input: target = 10, position = [3], speed = [3]
Output: 1
Explanation: There is only one car, hence there is only one fleet.
Example 3:
Input: target = 100, position = [0,2,4], speed = [4,2,1]
Output: 1
Explanation:
The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

 */
public class CarFleet {
    /*
    Here we create a 2D array where we create a pair of position and speed of a car
    And sort this 2D array according to  their position
    Create a stack which stores double
    we iterate from last to first in a 2D array
    Calculate the time current car takes to reach the target (target-posAndSpeed[i][0])/posAndSpeed[i][1] ie target-position/speed)
    if stack is not empty and current time is less than time in stack top then dont add it to stack as it will be in a fleet
    else add it to stack
    return size of the stack ie the amount of car fleet
    Time Complexity:O(N Log N)
    Space Complexity:O(N)
     */
    public int carFleetStack(int target, int[] position, int[] speed) {
        int[][] posAndSpeed=new int[position.length][2];
        for(int i=0;i< position.length;i++){
            posAndSpeed[i][0]=position[i];
            posAndSpeed[i][1]=speed[i];
        }
        Arrays.sort(posAndSpeed,(a,b)->Integer.compare(a[0],b[0]));
        Stack<Double>stack=new Stack<>();
        for(int i= posAndSpeed.length-1;i>=0;i--){
            double curTime=(double) (target-posAndSpeed[i][0])/posAndSpeed[i][1];
            if(!stack.isEmpty() && curTime<=stack.peek()){
                continue;
            }else {
                stack.push(curTime);
            }
        }
        return stack.size();
    }
    /*
    Here we create an array to note time for every positions let it be of size target
    then calculate the time for every positions
    iterate through the back of the time array if the curTime is less then previous then make previous as current time and increase number of car fleets
    Overall, this code approach leverages the pre-calculated arrival times stored in the time array and iterates through them in reverse order to efficiently
    determine fleet formation based on the "catching up" potential of each car.
    It achieves the same functionality as the previous solution with the stack but uses a slightly different strategy.
    Time Complexity:O(N)
    Space Complexity:O(N)
     */
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time=new double[target];
        for(int i=0;i<position.length;i++){
            time[position[i]]=(double)(target-position[i])/speed[i];
        }
        double prev=0.0;
        int res=0;
        for(int i=target-1;i>=0;i--){
            double curTime=time[i];
            if(curTime>prev){
                prev=curTime;
                res++;
            }
        }
        return res;
    }
    /*
Comparison with Stack-based Approach:
Both approaches achieve the same time complexity of O(n).
The stack-based approach has a slightly higher space complexity of O(2n) due to the additional stack and the two-dimensional posAndSpeed array.
This single-array approach with reverse iteration utilizes less space (O(n)) by directly storing arrival times and comparing them in reverse order.
     */
}
