package Sliding_Window;

import java.util.*;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */
public class PermutationinString {
    /*
Initialization:
Initialize lengths l1 and l2.
Create a HashMap count to store character counts of s1.
Count Characters:
Iterate through s1 and count characters, storing counts in count.
Sliding Window Approach:
Iterate through s2, forming a sliding window.
Check Matches:
Decrement character counts in count as characters in s2 are encountered.
Increment matches if count becomes zero.
Adjust Window:
If window exceeds l1, move it by decrementing counts of outgoing characters and incrementing counts of incoming characters.
Check Anagram:
If number of matches equals the size of count, return true.
Return Result:
If no anagram found, return false after iterating through s2.
     */
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        Map<Character,Integer> count=new HashMap<>();
        for(int i=0;i<l1;i++){
            char c=s1.charAt(i);
            count.put(c,count.getOrDefault(c,0)+1);
        }
        int matches=0;
        for(int i=0;i<l2;i++){
            char c=s2.charAt(i);
            if(count.containsKey(c)){
                count.put(c,count.get(c)-1);
                if(count.get(c)==0){
                    matches++;
                }
            }
            if(i>=l1){
                c=s2.charAt(i-l1);
                if(count.containsKey(c)){
                    if(count.get(c)==0){
                        matches--;
                    }
                    count.put(c,count.get(c)+1);
                }
            }
            if(matches==count.keySet().size()){
                return true;
            }
        }
        return false;
    }
}
