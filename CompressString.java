/*
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 */
public class CompressString {
    public static String compress(char[] chars) {
        StringBuilder ans = new StringBuilder("");
        // ans.append(chars[0]);
        int rep_count =1;
        for(int i=1;i<chars.length;i++){
            if(chars[i-1]==chars[i]){
                rep_count++;
            }
            else{
                if(rep_count==1){
                    ans.append(chars[i-1]);
                }
                else{
                    ans.append(chars[i-1]+""+rep_count+"");
                }
                rep_count=1;
            }
        }
        if(rep_count==1){
            ans.append(chars[chars.length-1]);
        }
        else{
            ans.append(chars[chars.length-1]+""+rep_count+"");
        }
        for(int i=0;i<ans.length();i++){
            chars[i]=ans.toString().charAt(i);
        }
        return ans.length();
    }
    public int compress(char[] chars) {
        int index = 0;
        int count = 0;

        for(int i=0; i<chars.length; i++) {
            count++;

            if(i+1 == chars.length || chars[i]!= chars[i+1]) {
                chars[index] = chars[i];
                index++;
                if(count != 1) {
                    for(char ch : Integer.toString(count).toCharArray()) {
                        chars[index] = ch;
                        index++;
                    }
                }
                count = 0;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        char[] a ={'a','a','b','b','c','c','c'};
        System.out.println(compress(a));
    }
}
