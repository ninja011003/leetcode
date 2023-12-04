import java.util.Scanner;

public class reduce_till_zero {
    public static int ReduceToZero(int x,int y){
        
        if(x<y){
            return ReduceToZero(y, x);
        }
        else if(y==0){
            return x;
        }
        else{
            return ReduceToZero(y, x-y);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter x,y: ");
        System.out.println(ReduceToZero(sc.nextInt(),sc.nextInt()));
        sc.close();
    }
}
