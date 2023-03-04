import java.util.LinkedList;
import java.util.Queue;

public class zigzagconv {
    /*
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string s, int numRows);
     * Example 1:
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     */
    public static String convert(String s, int numRows) {
        StringBuffer ans = new StringBuffer();
        Queue<Character>[] bundle= new Queue[numRows];
        for(int i=0;i<numRows;i++){
            bundle[i]= new LinkedList<Character>();
        }
        int flag =1,k=0;
        for(int i=0;i<s.length();i++){
            bundle[k].add(s.charAt(i));
            if(numRows==1)
                continue;
            if(k==numRows-1)
                flag=-1;
            if(k==0)
                flag=1;
            if(flag>0)
                k++;
            if(flag<0)
                k--;
        }
        for(int i=0;i<numRows;i++){
            while(!bundle[i].isEmpty()){
                ans.append(bundle[i].poll());
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
