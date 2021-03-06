package hatecode;
import java.util.*;
public class MinimumAddToMakeParenthesesValid {
/*
921. Minimum Add to Make Parentheses Valid
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: "())"
Output: 1
*/
    public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
/*
1. if encounter '(', push '(' into stack;
2. otherwise, ')', check if there is a matching '(' on top of stack; 
if no, increase the counter by 1; if yes, pop it out;
3. after the loop, count in the un-matched characters remaining in the stack.
 */
    public int minAddToMakeValid2(String S) {
        //only store "("
        Deque<Character> stk = new ArrayDeque<>();
        //count )
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') { stk.push(c); }
            else if (stk.isEmpty()) { ++count; }
            //if we find good mapping then pop(), like ()
            else { stk.pop(); }
        }
        return count + stk.size();
    }
}