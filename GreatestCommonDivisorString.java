/*
 * https://leetcode.com/problems/greatest-common-divisor-of-strings
 */

import java.util.HashSet;
import java.util.Set;

public class GreatestCommonDivisorString {
    public String gcdOfStrings(String str1, String str2) {
        String min, max,ans="";
        if(str1.length()>str2.length()){
            max=str1;
            min=str2;
        }
        else{
            max=str2;
            min=str1;
        }
        int i=0,j=0;
        Set<String> comStr = new HashSet<>();
        StringBuilder str = new StringBuilder("");
        while(i<max.length()&&j<min.length()){
            if(max.charAt(i)==min.charAt(j)){
                str.append(max.charAt(i));
            }
            else{
                comStr.add(str.toString());
            }
            i++;
            j++;
        }
        return ans;
    }
}
