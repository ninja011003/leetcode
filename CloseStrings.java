/**
 * CloseStrings
 * https://leetcode.com/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
public class CloseStrings {
    public  static boolean closeStrings(String word1, String word2) {
        //My stupid Internals:-  16 15 17 21 18
        // if(word1.length()!=word2.length()){
        //     return false;
        // }
        // HashMap<Character,Integer> w1= new HashMap<>();
        // HashMap<Character,Integer> w2= new HashMap<>();
        // Boolean ans = false;
        // int i=0,j=0;
        // while(i<word1.length()&&j<word2.length()){
        //     w1.put(word1.charAt(i), w1.getOrDefault(word1.charAt(i), 0)+1);
        //     w2.put(word1.charAt(j), w2.getOrDefault(word1.charAt(j), 0)+1);
        //     i++;
        //     j++;
        // }
        // while (i < word1.length()) {
        //     w1.put(word1.charAt(i), w1.getOrDefault(word1.charAt(i), 0) + 1);
        //     i++;
        // }
        // while (j < word2.length()) {
        //     w2.put(word2.charAt(j), w2.getOrDefault(word2.charAt(j), 0) + 1);
        //     j++;
        // }
        if(word1.length()!=word2.length()){
            return false;
        }
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for(int i=0;i<word1.length();i++){
            w1[word1.charAt(i)-97]++;
            w2[word2.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            if(w1[i]!=0&&w2[i]==0||w2[i]!=0&&w1[i]==0)
                return false;
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        for(int i=0;i<26;i++){
            if(w1[i]!=w2[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        closeStrings("abcceee", "abcdef");
    }
    
}