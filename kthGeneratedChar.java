public class kthGeneratedChar {
    public char KthCharacter(int k){
        StringBuilder str = new StringBuilder("a");
        while(str.length()<k){
            int size = str.length();
            for(int i=0;i<size;i++){
                if(str.charAt(i)=='z'){
                    str.append('a');
                }
                else{
                    str.append((char)(str.charAt(i)+1));
                }
            }
        }
        return str.charAt(k-1);
    }
    public static void main(String[] args) {
        System.out.println(KthCharacter(5));
    }
}





