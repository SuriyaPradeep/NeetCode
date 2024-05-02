package Stack;
import java.util.*;
/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {
    /*
    We dijkstra's two stack algorithm to solve this problem
    Create a stack to store integers.
    Iterate through the string array check whether the current string equals any of the operand +,-,*,/.
    If not push the string to stack as integer.
    If it is any of operand then pop stack two times to get recent two numbers and perform calculations according to given operand.
    And push the calculated value to the stack.
    Time Complexity:O(N)
    Space Complexity:O(N)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer>stack=new Stack<>();
        for(String str:tokens){
            if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")){
                int num2=stack.pop(),num1=stack.pop();
                stack.push(calculate(num1,num2,str));
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    private int calculate(int num1,int num2,String operand){
        switch(operand){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
            default:
                return -1;
        }
    }

    //Alternate
    public int evalRPN1(String[] tokens) {
        List<String> operators = List.of("+", "-", "*", "/");
        Stack<Integer>stack=new Stack<>();
        int total=0;
        for(String str:tokens){
            if(operators.contains(str)){
                int b=stack.pop(),a=stack.pop();
                stack.push(calculate(a,b,str));
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
