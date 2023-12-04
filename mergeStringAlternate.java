public class mergeStringAlternate {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer str = new StringBuffer("");
        int i=0;
        while(i<word1.length()&&i<word2.length()){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
            i++;
            
        }
        while(i<word1.length()){
            str.append(word1.charAt(i));
            i++;
        }
        while(i<word2.length()){
            str.append(word2.charAt(i));
            i++;
        }
        return str.toString();
    }
}
