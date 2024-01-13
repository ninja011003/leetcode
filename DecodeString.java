/*
 * https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
class DecodeString{
    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer("");
        int openBracCount=0,repeatCount=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                i++;
                openBracCount=1;
                StringBuffer str = new StringBuffer("");
                while(s.charAt(i)!=']'||openBracCount!=1){
                    if(s.charAt(i)=='['){
                        openBracCount++;
                    }
                    if(s.charAt(i)==']'){
                        openBracCount--;
                    }
                    str.append(s.charAt(i));
                    i++;
                }
                String temp = decodeString(str.toString());
                for(int k=0;k<repeatCount;k++){
                    ans.append(temp);
                }
                
            }
            else if(s.charAt(i)>47&&s.charAt(i)<59){
                repeatCount=0;
                while(s.charAt(i)>47&&s.charAt(i)<59){
                    repeatCount= repeatCount*10+(s.charAt(i)-48);
                    i++;
                }
                i--;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
