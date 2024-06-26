import java.util.Arrays;

public class ab2 {
    public static int[] calcualtePrimeNumber(int num){
        int[] answer =new int[100];
        answer[0]=2;
        int k=1;
        for(int i=3;i<=num;i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
                    break;
                }
                if(j==i-1){
                    answer[k++]=i;
                }
            }
        }
        int[] arr = new int[k];
        for(int i=0;i<k;i++){
            arr[i]=answer[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(calcualtePrimeNumber(11)));
    }
}
