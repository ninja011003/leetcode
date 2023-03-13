import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombination {
    /*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []

    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]
    
    Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9']. 
    */
    public static char[] value(Character c){
        if(c<'7'){
            int n= (3*c)-53;
            return new char[] {(char) (n),(char) (n+1),(char) (n+2)};
        }
        else if(c=='7'){
            return new char[] {'p','q','r','s'};
        }
        else if(c=='8'){
            return new char[] {'t','u','v'};
        }
        else{
            return new char[] {'w','x','y','z'};
        }
    }
    public static void combinate(char[][] arrays,String current,int index,List<String> ans){
        if(index==arrays.length){
            ans.add(current);
            return;
        }
        for(char s : arrays[index]){
            combinate(arrays, current+s, index+1, ans);
        }

    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits.length()==0){
            return ans;
        }
        char[][] arrays = new char[digits.length()][];
        for(int i=0;i<digits.length();i++){
            arrays[i]= value(digits.charAt(i));
            System.out.println(Arrays.toString(arrays[i]));
        }
        combinate(arrays, "", 0, ans);
        return ans;
    }
    public static void main(String[] args) {
        /*
         * 50:97
         * 51:100
         * 52:103
         */
        System.out.println(letterCombinations(""));
    }
}
