package Binary_Search;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).
Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianofTwoSortedArrays {
    /*
The function findMedianSortedArrays takes in two sorted arrays nums1 and nums2 and finds the median of the combined sorted array.
It first checks the lengths of both arrays and swaps them if necessary so that nums1 is always the smaller array.
Calculates the total length of the combined array n.
Determines the partition of the combined array where the left partition has (n + 1)/2 elements.
Initializes variables for binary search (left and right) and for storing partition indices (mid1 and mid2).
Enters a binary search loop where it iteratively adjusts the partition points to find the median.
Calculates the left and right elements of each partition (l1, l2, r1, r2) taking care of boundary conditions.
Checks if the elements in the left partition are less than or equal to the elements in the right partition.
If the condition is met, returns the median based on whether n is odd or even.
Adjusts the search space (left or right) based on the comparison of l1 and r2.
Returns 0 if the arrays are empty or no median is found.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length,n2= nums2.length;;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n=n1+n2;
        int leftPartition=(n+1)/2;
        int left=0,right=n1;
        while (left<=right){
            int mid1=(left+right)>>1;
            int mid2=leftPartition-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1){
                r1=nums1[mid1];
            }
            if(mid2<n2){
                r2=nums2[mid2];
            }
            if(mid1-1>=0){
                l1=nums1[mid1-1];
            }
            if(mid2-1>=0){
                l2=nums2[mid2-1];
            }
            if(l1<=r2 && l2<=r1){
                if(n%2==1){
                    return Math.max(l1,l2);
                }else{
                    return ((double)Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }else if(l1>r2) {
                right=mid1-1;
            }else{
                left=mid1+1;
            }
        }
        return 0;
    }
}
