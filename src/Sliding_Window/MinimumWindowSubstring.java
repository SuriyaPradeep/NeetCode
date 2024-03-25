package Sliding_Window;

import java.util.HashMap;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.
Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */
public class MinimumWindowSubstring {
    /*
Input Validation:
Checks for null or empty strings and if s is shorter than t, returning an empty string if any condition fails.
Character Counts:
Counts characters in string t using a HashMap.
Sliding Window Approach:
Initializes variables for tracking the minimum window (startIndex, minLen) and match count (match).
Uses two pointers (left and right) to iterate through string s.
Iterating through s:
Updates character counts in the count map for characters in s.
Adjusting Window:
Enters a loop when all characters in t are found in the current window of s.
Updates minLen and startIndex for the smallest window found so far.
Shrinks the window by moving the left pointer (left) and updating counts in the count map.
Returning Result:
Returns the minimum window substring of s containing all characters of t, or an empty string if no such window is found.

     */
    public static String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length() || s.length()==0 || t.length()==0){
            return "";
        }
        HashMap<Character,Integer>count=new HashMap<>();
        for(char c:t.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        int startIndex=0,minLen=Integer.MAX_VALUE,match=0;
        char[] sArray=s.toCharArray();
        for(int left=0,right=0;right<sArray.length;right++){
            char curr=sArray[right];
            if(count.containsKey(curr)){
                count.put(curr,count.get(curr)-1);
                if(count.get(curr)==0){
                    match++;
                }
            }
            while(match==count.size()){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startIndex=left;
                }
                curr=sArray[left++];
                if(count.containsKey(curr)){
                    if(count.get(curr)==0){
                        match--;
                    }
                    count.put(curr,count.get(curr)+1);
                }
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(startIndex,minLen+startIndex);
    }
}
