/*
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class ReverseWords {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                word.append(s.charAt(i));
            }
            else{
                if(word.length()!=0){
                    words.add(word.toString());
                    word= new StringBuilder("");
                }
                else{
                    continue;
                }
            }
        }
        if(word.length()!=0){
            words.add(word.toString());
        }
        word= new StringBuilder("");
        for(int i = words.size()-1;i>0;i--){
            word.append(words.get(i));
            word.append(' ');
        }
        word.append(words.get(0));
        return word.toString();
    }
}
