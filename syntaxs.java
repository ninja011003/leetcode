import java.util.*;
public class syntaxs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            if(arr[i]==0){
                for(int j=i;j<n-1;j++){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        

        //1 0 2 0 3
        //0 1 2 3 4
    }
}
