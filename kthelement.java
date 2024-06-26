import java.util.Arrays;
import java.util.Scanner;

public class kthelement {
    public static Scanner sc = new Scanner(System.in);
    public static int kthsmallest(int n,int k,int[] a){
        if(k>=n)
            return 0;
        Arrays.sort(a);
        return a[k-1];
    }
    public static void main(String[] args) {
        int n= sc.nextInt();
        int k =sc.nextInt();
        int[] arr = new int[n];
        for( int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(kthsmallest(n,k,arr));
    }
}
