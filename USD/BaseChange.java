

public class BaseChange {
    public static int base(int N,int K, int MOD,int[] AR){
        int x=0,p=N-1;
        for(int i=0;i<N;i++){
            
            x+=AR[i]*((int)Math.pow(K,p));
            System.out.println(x);
            p--;
        }
        
        return (int)x%MOD;
    } 
    public static String max_number(String A,String L){
        StringBuffer ans = new StringBuffer("");
        StringBuilder temp = new StringBuilder(A);
        for(int i=0;i<L.length();i++){
            int index=temp.indexOf(""+L.charAt(i));
            temp.setCharAt(index,'`');
        }
        char[] string = temp.toString().toCharArray();
        for(int i=0;i<string.length;i++){
            if(string[i]!='`'){
                ans.append(string[i]);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args){
        int[] AR={11,3};
        System.out.println(max_number("23891343798921", "22878193199"));
    }
}
