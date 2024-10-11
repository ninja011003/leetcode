import java.util.Scanner;
final class s{
    
}
class fruit{
    public String taste;
    public void eat(){
        System.out.println(taste);
    }
}
class orange extends fruit{
    @Override
    public void eat(){
        System.out.println("orange");
    }
}
class apple extends fruit{
    @Override
    public void eat(){
        System.out.println("apple");
    }
}
public class encapsulation {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        //palindrome
        /*
         * a b c a
         * 0 1 2 3
         * n=4
         */
    //    String str = sc.next();
    //    int n = str.length();
    //     for(int i =0;i<n/2;i++){
    //         if(str.charAt(i)!=str.charAt(n-i-1)){
    //             System.out.println("Its not a palindrome");
    //             return;
    //         }
    //     }
        System.out.println("Its a palindrome");
        int a=1,b=0;
        
    }
}
