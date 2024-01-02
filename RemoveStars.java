/*
 * https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character>  stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c!='*'){
                stack.add(c);
            }
            else{
                stack.pop();
            }
        }
        StringBuilder ans= new StringBuilder("");
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
