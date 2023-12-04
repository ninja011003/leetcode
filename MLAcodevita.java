// import java.util.Arrays;
// import java.util.Collection;
// import java.util.Scanner;

// public class MLAcodevita {
//     public static Scanner sc = new Scanner(System.in);
//     public static int minTime = Integer.MAX_VALUE;
//     public static void minTimeComputer(int[][] combination,int i,int c1timeTaken,int c2timeTaken){
//         if(c1timeTaken>=minTime||c2timeTaken>=minTime){
//             return;
//         }
//         if(i==combination[0].length-1){
//             if(Math.max(c1timeTaken, c2timeTaken)<minTime){
//                 minTime=Math.max(c1timeTaken, c2timeTaken);
//             }
//             return;
//         }
//         else{
//                 minTimeComputer(combination,i+1,c1timeTaken+combination[0][i],c2timeTaken);
//                 minTimeComputer(combination,i+1,c1timeTaken,c2timeTaken+combination[1][i]);
//         }
        
//     }
//     public static void main(String[] args) {
//         int t1 = sc.nextInt();
//         int t2 = sc.nextInt();
//         int min = Math.min(t1,t2);
//         int max= Math.max(t1, t2);
//         int villageCount = sc.nextInt();
//         int[] input = new int[villageCount];
//         for(int i = 0;i< villageCount;i++){
//             input[i]=sc.nextInt();
//         }
//         Arrays.sort(input);
//         int[] population = new int[villageCount];
//         int[][] combination = new int[2][villageCount];
//         for(int i=0;i<villageCount;i++){
//             population[i]= input[villageCount-i-1];
//             combination[0][i]= population[i]*min;
//             combination[1][i]= population[i]*max;
//         }
//         // System.out.println(Arrays.toString(combination[0]));
//         // System.out.println(Arrays.toString(combination[1]));
//         minTimeComputer(combination, 0,0, 0);
//         System.out.print(minTime);
//     }
// }

import java.util.Arrays;
import java.util.Scanner;

public class MLAcodevita {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt(); 
        int m2 = sc.nextInt(); 
        int N = sc.nextInt(); 
        int[] populations = new int[N];

        for (int i = 0; i < N; i++) {
            populations[i] = sc.nextInt();
        }

      
        Village[] villages = new Village[N];
        for (int i = 0; i < N; i++) {
            villages[i] = new Village(i, populations[i]);
        }
        Arrays.sort(villages, (v1, v2) -> Integer.compare(v2.population, v1.population));

       
        long total_time_center1 = 0;
        long total_time_center2 = 0;

       
        for (Village village : villages) {
            if (total_time_center1 <= total_time_center2) {
                total_time_center1 += (long) village.population * m1;
            } else {
                total_time_center2 += (long) village.population * m2;
            }
        }

       
        long answer = Math.max(total_time_center1, total_time_center2);
        System.out.print(answer);
    }

    static class Village {
        int index;
        int population;

        public Village(int index, int population) {
            this.index = index;
            this.population = population;
        }
    }
}