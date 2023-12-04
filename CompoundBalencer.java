import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CompoundBalencer
 */
public class CompoundBalencer {
    public static void BalanceComputer(String str,int eqv_pt){
        int v1= (int)str.charAt(0);
        int v2= (int)str.charAt(1);
        // System.out.println(v1+" "+v2);
        while((v1+"").length()>1){
            v1=((v1/10))+(v1%10);
        }
        while((v2+"").length()>1){
            v2=((v2/10))+(v2%10);
        }
        // System.out.println(v1+" "+v2);
        int q = eqv_pt/v1;
        // System.out.println(q);
        if(q*v1==eqv_pt){
                q--;
        }
        int count =0;
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        while(q>0){
            int i=1;
            // while(((q*v1)+(v2*i))<eqv_pt){
            //     i++;
            // }
            i= (eqv_pt-(q*v1))/v2;
            if((q*v1)+(v2*i)==eqv_pt){
                // count++;
                A.add(q);
                B.add(i);
                // System.out.println(str.charAt(0)+""+q+" "+str.charAt(1)+""+i);
            }
            q--;
        }
        if(A.size()==0){
            System.out.println("Not Possible");
        }
        else{
            for(int i=0;i<A.size()-1;i++){
                System.out.println(str.charAt(0)+""+A.get(i)+" "+str.charAt(1)+""+B.get(i));
            }
            System.out.println(str.charAt(0)+""+A.get(A.size()-1)+" "+str.charAt(1)+""+B.get(A.size()-1));
        }
    }
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.next();
        int eqv_pt = sc.nextInt();
        BalanceComputer(str, eqv_pt);
    }
    
}


