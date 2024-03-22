package Binary_Search;
/*
You are given an m x n integer matrix  with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */
public class Searcha2DMatrix {
    /*
      Consider this 2D as a single array.
      find row and column value and start=0 end=row*col-1
      iterate through array while start<=end
      find mid of start and end.Now to get the value set row=mid/col and col=mid%col
      Now compare the value to target if value==target return true
      if value<target start=mid+1
      if value>target end=mid-1
      If element not found return false
      Time Complexity:O(log(m * n))
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start=0,row=matrix.length,col=matrix[0].length;
        int end=row*col-1;
        while(start<=end){
            int mid=(start+end)/2,value=matrix[mid/col][mid%col];
            if(value==target){
                return true;
            }else if(value<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}
