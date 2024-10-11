import java.util.Arrays;

public class wipro2 {
    public int findPin(int input1, int input2,int input3,int input4) {
        int[] nums ={input1,input2,input3};
        int[][] arr = new int[3][4];
        for(int i=0;i<3;i++){
            int temp = nums[i];
            int k=3;
            while(temp>0){
                arr[i][k]=temp%10;
                temp/=10;
                k--;
            }
        }
        int evenPos =0, oddPos = 0;
        for(int i=0;i<3;i++){
            evenPos = evenPos+arr[i][0]+arr[i][2];
            oddPos= oddPos+arr[i][1]+arr[i][3];
        }
        if(input4%2==0){
            return evenPos-oddPos;
        }
        else{
            return oddPos-evenPos;
        }

    }
    public static void main(String[] args) {
        System.out.println(findPin(4413,5816,1780,25));
    }
}
