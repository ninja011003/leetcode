/*
 * https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class ReverseVowel {
    public String reverseVowels(String s) {
        char[] revStr = new char[s.length()];
        char[] vowel_list ={'a','e','i','o','u','A','E','I','O','U'};
        List<Character> vowels = new ArrayList<>();
        for(char c: vowel_list){
            vowels.add(c);
        }
        int  v_count= -1;
        for(int i=0;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                v_count++;
                revStr[v_count]=s.charAt(i);
            }
        }
        StringBuffer ans = new StringBuffer("");
        for(int i=0;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                ans.append(revStr[v_count]);
                v_count--;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
        
    }
    public static void main(String[] args) {
        
        
        

        
    }
}
