package Two_Pointer;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome {
    /*
    We can find whether the given string is palindrome using 2 pointer method.
    Let's initialize two pointer i and j pointing to start and end of the string respectively.
    Increase i if the character it is pointing to is not alphanumeric.In case of j decrease it.
    If both characters are alphanumeric then check if they are same if not return false.
    Increment and Decrement the pointer's.
    Time Complexity:O(N)
    Space Complexity:O(1)
     */
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(!Character.isLetterOrDigit(c1)){
                i++;
            }else if(!Character.isLetterOrDigit(c2)){
                j--;
            }else{
                if(Character.toLowerCase(c1)!=Character.toLowerCase(c2)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
