package Binary_Search;
/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */
public class KokoEatingBananas {
    /*
    We will use binary search to solve this
    first we will have two pointers left ie 1 since it would be minimum amount banana that koko needs to eat in an hour
    here length of piles would be less than h.
    right will be the maximum value in the piles
    we do a binary search from left to right ie 1 to max pile
    here we call a support function that determines whether current k ie mid value will be enough to eat all piles within given time
    if not then increase left to mid+1
    return right
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            right=Math.max(right,piles[i]);
        }
        while(left<right){
            int mid=(left+right)/2;
            if(canEat(mid,piles,h)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    private boolean canEat(int maxPile,int[] piles,int h){
        int hrs=0;
        for(int pile:piles){
            int time=pile/maxPile;
            hrs+=time;
            if(pile%maxPile!=0){
                hrs++;
            }
        }
        if(hrs<=h){
            return true;
        }
        return false;
    }
}
