package Sliding_Window;

import java.util.*;

/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
The function lengthOfLongestSubstring takes a string s as input and returns the length of the longest substring without repeating characters.
It initializes variables: res to store the result (length of the longest substring), and a HashMap called hash to store characters as keys and their indices as values.
It iterates through the string s using a sliding window approach with two pointers: left and right.
As the right pointer moves forward, it checks if the character at right is already present in the HashMap. If it is, it updates the left pointer to the maximum of its current value and the index of the repeated character + 1. This ensures that left moves past the previous occurrence of the repeated character.
Calculates the length of the current substring (right - left + 1) and updates the result res if this length is greater than the previous maximum.
Updates the HashMap with the current character and its index.
Finally, returns the result res, which represents the length of the longest substring without repeating characters in the given string s.
     */
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Map<Character,Integer> hash=new HashMap<>();
        for(int right=0,left=0;right<s.length();right++){
            if(hash.containsKey(s.charAt(right))){
                left=Math.max(left,hash.get(s.charAt(right))+1);
            }
            res=Math.max(res,right-left+1);
            hash.put(s.charAt(right),right);
        }
        return res;
    }
}
