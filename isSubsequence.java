/*
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int s_ptr =0,t_ptr=0;
        while(s_ptr<s.length()&&t_ptr<t.length()){
            if(s.charAt(s_ptr)==t.charAt(t_ptr)){
                s_ptr++;   
            }
            t_ptr++;
        }
        return s_ptr==s.length();
    }
}
