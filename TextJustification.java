/*
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TextJustification {
    public static String greedyString(int maxWidth,int lineLength,String[] words,ArrayList<Integer> word_seq){
        StringBuffer line = new StringBuffer("");
        int midSpace,extraSpace;
        if(word_seq.size()==1){
            midSpace=maxWidth-words[word_seq.get(0)].length();
            // midSpace=0;
            extraSpace=0;
        }
        else{
            midSpace = (maxWidth - lineLength) / (word_seq.size() - 1); // quotient for equal spaces
            extraSpace = (maxWidth - lineLength) % (word_seq.size() - 1);
        }
        for (int j = 0; j < word_seq.size(); j++) {
            if (extraSpace != 0) {
                line.append(words[word_seq.get(j)]);
                for(int k=0;k<midSpace+1;k++){
                    line.append(" ");
                }
                extraSpace--;
            } 
            else {
                line.append(words[word_seq.get(j)]);
                if(j!=word_seq.size()-1||word_seq.size()==1)
                    for (int k = 0; k < midSpace; k++) {
                        line.append(" ");
                    }
            }
        }
        System.out.println(line.toString());
        return line.toString();
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        ArrayList<Integer> word_seq = new ArrayList<>();
        int lineLength = 0;
        for (int i = 0; i < words.length; i++) {
            int newLineLength = lineLength + words[i].length();
            if(words[i].length()==maxWidth){
                if(!word_seq.isEmpty()){
                    while((maxWidth - lineLength) < (word_seq.size() - 1)){
                        lineLength-=words[word_seq.remove(word_seq.size()-1)].length();
                        i--;
                    }
                    ans.add(greedyString(maxWidth, lineLength, words, word_seq));
                    i--;
                }
                else{
                    ans.add(words[i]);
                }
                word_seq = new ArrayList<>();
                lineLength = 0;
                newLineLength=0;
                continue;
            }
            else if (newLineLength >= maxWidth) {
                while((maxWidth - lineLength) < (word_seq.size() - 1)){
                    lineLength-=words[word_seq.remove(word_seq.size()-1)].length();
                    i--;
                }
                // System.out.println(word_seq.size());
                ans.add(greedyString(maxWidth, lineLength, words, word_seq));
                word_seq = new ArrayList<>();
                i--;
                lineLength = 0;
                newLineLength=0;
            }
            else {
                word_seq.add(i);
                lineLength = newLineLength;
            }
            if(word_seq.isEmpty()==false&&i==words.length-1){
                ArrayList<Integer> lastline = new ArrayList<>();
                while((maxWidth - lineLength) < (word_seq.size() - 1)){
                    int lastword =word_seq.remove(word_seq.size()-1);
                    lineLength-=words[lastword].length();
                    lastline.add(lastword);
                } 
                StringBuffer line = new StringBuffer("");
                if(!lastline.isEmpty()){
                    ans.add(greedyString(maxWidth, lineLength, words, word_seq));   
                    for(int k=lastline.size()-1;k>0;k--){
                        line.append(words[lastline.get(k)]);
                        line.append(" ");
                    }
                    line.append(words[lastline.get(0)]);    
                } 
                else{
                    for(int k=0;k<word_seq.size()-1;k++){
                        line.append(words[word_seq.get(k)]);
                        line.append(" ");
                    }
                    line.append(words[word_seq.get(word_seq.size()-1)]);
                } 
                int n=maxWidth-line.length();
                for(int k=0;k<n;k++){
                    line.append(" ");
                }
                ans.add(line.toString());  
            }
        }
        return ans;
    }

    
    public static void main(String[] args) {
        // String[] strings = {"This", "is", "an", "example", "of", "text", "justification."};
        // String[] strings = {"Listen","to","many,","speak","to","a","few."};
        String[] strings = {"example","of","text","justification."};
        System.out.println(Arrays.toString(fullJustify(strings, 14).toArray(new String[0])));
    }
}