import java.util.Scanner;

public class TrafficFlow {
    public static int minDist = Integer.MAX_VALUE;
    public static int M=0,N=0;
    public static int d_x=0,d_y=0;
    public static int minTimeCompute(int[][] arr,int s_x,int s_y){
        if(s_x>d_x||s_y>d_y){
            return -1;
        }
        int[][] timeCost = new int[M][N];
        timeCost[s_x][s_y]=arr[s_x][s_y];
        for(int i=s_y+1;i<=d_y;i++){
            timeCost[s_x][i]=timeCost[s_x][i-1]+arr[s_x][i];
        }
        for(int i=s_x+1;i<=d_x;i++){
            timeCost[i][s_y]=timeCost[i-1][s_y]+arr[i][s_y];
        }
        for (int i = s_x + 1; i <= d_x; i++) {
            for (int j = s_y + 1; j <= d_y; j++) {
                timeCost[i][j] = arr[i][j] + Math.min(timeCost[i - 1][j], timeCost[i][j - 1]);
            }
        }
        return timeCost[d_x][d_y];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M=sc.nextInt();
        N= sc.nextInt();
        int[][] arr = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int s_x = sc.nextInt()-1;
        int s_y = sc.nextInt()-1;
        d_x=sc.nextInt()-1;
        d_y=sc.nextInt()-1;
        System.out.print(minTimeCompute(arr, s_x, s_y ));   
    }
}
