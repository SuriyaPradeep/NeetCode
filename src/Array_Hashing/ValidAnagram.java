package Array_Hashing;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagram {
    /*
    Anagram of word is words with same letter counts in different order.
    If both strings have different lengths then we can say it is not an anagram.
    Let's have count array which will count every letter's.
    Array will start with all count to zero.
    Increase the count for string s.
    Decrease the count for string t.
    After this if array is still 0 then it is anagram.

    Time:O(N)
    Space:O(N)
     */
    public boolean isAnagram(String s, String t) {
        int n=s.length(),m=t.length();
        if(n!=m){
            return false;
        }
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        for(char c:t.toCharArray()){
            count[c-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
