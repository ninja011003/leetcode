import java.util.Scanner;

public class BoardGame {
    public static int minDist = Integer.MAX_VALUE;
    public static int M=0,N=0;
    public static int dest_x=0,dest_y=0,mv_r_i=0,mv_r_j=0;
    public static void shortestPathComputer(int[][] arr,int i,int j,int[][] visited,int dist){
        if(i==dest_x&&j==dest_y){
            if(dist<minDist){
                minDist=dist;
            }
            return; 
        }
        if(i<0||j<0||i>=M||j>=N){
            return;
        }
        if(arr[i][j]==1||(visited[i][j]!=0&&visited[i][j]<dist)||dist>minDist){
            // System.out.println("j");
            return;
        }
        visited[i][j]=dist;
        shortestPathComputer(arr, i+mv_r_i, j+mv_r_j, visited, dist+1);
        shortestPathComputer(arr, i-mv_r_i, j-mv_r_j, visited, dist+1);
        shortestPathComputer(arr, i+mv_r_j, j-mv_r_i, visited, dist+1);
        shortestPathComputer(arr, i-mv_r_j, j+mv_r_i, visited, dist+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M=sc.nextInt();
        N= sc.nextInt();
        int[][] arr = new int[M][N];
        int[][] visited = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int source_x = sc.nextInt();
        int source_y = sc.nextInt();
        dest_x=sc.nextInt();
        dest_y=sc.nextInt();
        mv_r_i=sc.nextInt();
        mv_r_j=sc.nextInt();
        shortestPathComputer(arr, source_x, source_y,visited, 0);
        if(minDist==Integer.MAX_VALUE){
            System.out.print(-1);
        }
        else{
            System.out.print(minDist);
        }
    }
}
