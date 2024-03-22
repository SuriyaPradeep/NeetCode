package Stack;
import java.util.*;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]
 */
public class GenerateParentheses {
    /*
    BackTrack tree for when n=2
    								   	(0, 0, '')
								 	    |
									(1, 0, '(')
								   /           \
							(2, 0, '((')      (1, 1, '()')
							   /                 \
						(2, 1, '(()')           (2, 1, '()(')
						   /                       \
					(2, 2, '(())')                (2, 2, '()()')
						      |	                             |
					res.add('(())')             res.add('()()')
     */
    /*
    We solve this using backtracking.
    We dont stack here but we can use stack to add brackets to it then pop them to add to the list.

The idea is to add ')' only after valid '('
We use two integer variables openB & closeB to see how many '(' & ')' are in the current string
If openB < n then we can add '(' to the current string
If closeB < openB then we can add ')' to the current string
     */
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,0,0,n,"");
        return res;
    }
    private void backtrack(List<String> res,int openB,int closeB,int n,String s){
        if(openB==closeB && closeB==n){
            res.add(s);
            return;
        }
        if(openB<n){
            backtrack(res,openB+1,closeB,n,s+"(");
        }
        if(closeB<openB){
            backtrack(res,openB,closeB+1,n,s+")");
        }
    }
}
