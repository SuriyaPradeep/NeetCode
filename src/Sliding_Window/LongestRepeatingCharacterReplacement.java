package Sliding_Window;
/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 */
public class LongestRepeatingCharacterReplacement {
    /*
The function characterReplacement takes two parameters: a string s and an integer k, where s represents the input string and k represents the maximum number of character replacements allowed.
It initializes variables res to store the result (length of the longest substring after replacements), and mostFreq to keep track of the most frequently occurring character in the current window.
It also initializes an array count of size 26 to store the count of characters encountered so far.
The code uses a sliding window approach with two pointers left and right to traverse the string.
For each character encountered at index right, it increments the count of that character in the count array.
It updates mostFreq to maintain the count of the most frequently occurring character in the current window.
Calculates the number of characters that need to be changed (replaced) to make all characters in the window the same (i.e., the length of the window minus the count of the most frequent character).
If the number of characters to be changed (letterChange) exceeds k, it adjusts the window by moving the left pointer and decrementing the count of the character at the left end of the window.
Updates the result res to keep track of the maximum length of the window encountered so far.
Returns the final result res, which represents the length of the longest substring after at most k character replacements.
     */
    public int characterReplacement(String s, int k) {
        int res=0,mostFreq=0;
        int[] count=new int[26];
        for(int left=0,right=0;right<s.length();right++){
            char c=s.charAt(right);
            count[c-'A']++;
            mostFreq=Math.max(mostFreq,count[c-'A']);
            int letterChange=(right-left+1)-mostFreq;
            if(letterChange>k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}
