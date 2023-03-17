import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class  GenerateParenthesis{
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        Set<String> unique = new HashSet<String>();
        result.add("()");
        for(int i=0;i<n-1;i++){
            int lim=result.size();
            for(int j=0;j<lim;j++){
                StringBuilder str = new StringBuilder(result.get(j));
                for(int k=0;k<str.length();k++){
                    //System.out.println(str.toString());
                    str.insert(k, "()");
                    //System.out.println(str.toString());
                    unique.add(str.toString());
                    str.delete(k, k+2);
                }
            }
            result.clear();
            result.addAll(unique);
            unique.clear();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}