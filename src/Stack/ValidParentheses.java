package Stack;
import java.util.*;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
 */
public class ValidParentheses {
    /*
    Create a stack.
    add Every { [ ( characters to stack.
    if anything else comes up check is stack is empty then return false.
    if not pop stack and compare current char and popped elements match if not return false.
    After all iteration check if stack is empty return that as answer.
    Time Complexity:O(N)
    Space Complexity:O(N)
     */
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char bracket=stack.pop();
                if(c==')'&&bracket!='('||c==']'&&bracket!='['||c=='}'&&bracket!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
