public class FirstOccurenceString {
    public static int strStr(String haystack, String needle) {
        //loop execution
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.substring(i, i+needle.length()).equals(needle))
                return i;
        }
        return -1;
        /* 
        //builtin function
        if(haystack.contains(needle))
            return haystack.indexOf(needle);
        else
            return -1;
        */
    }
    public static void main(String[] args) {
        System.out.println(strStr("leetcode", "code"));
    }
}
