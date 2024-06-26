import java.util.*;
public class MaxDiff{
    public static Scanner sc = new Scanner(System.in);
    public static int computeMaxDiff(int[] arr){
        int max=Integer.MIN_VALUE
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp = arr[j]-arr[i];
                if(temp>max){
                    max=temp;
                }
            }
        }
        if(max<0){
            max=-1;
        }
        System.out.print("The maximum difference is "+max);
        return max;
    }
    public static void main(String[] args ){
        System.out.print("Enter the number of elements in the array:");
        int n = sc.nextInt();
        System.out.print("Enter the elements of the array:");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        computeMaxDiff(arr);
    }
}