/*
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.List;
public class MaxVowels {
    public int maxVowels(String s, int k) {
        List<Character> vowels = new ArrayList<>();
        for(char c : "aeiou".toCharArray()){
            vowels.add(c);
        }
        int count =0;
        int max=0
        for(int i=0;i<k;i++){
            if(vowels.contains(s.charAt(i))){
                count++;
            }
        }
        max = count;
        for(int i=1;i<=s.length()-k;i++){
            if(count==k){
                return count;
            }
            if(vowels.contains(s.charAt(i-1))){
                count--;
            }
            if(vowels.contains(s.charAt(i+k-1))){
                count++;
            }
            if(count>max){
                max=count;
            }
        }
        return max;
    }
}
