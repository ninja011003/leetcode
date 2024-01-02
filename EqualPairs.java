/*
 * https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class EqualPairs {
    public static boolean compareArr(int[] arr1,int[] arr2){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }

    public static int equalPairs(int[][] grid) {
        int count=0;
        List<int[]> cols = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            rows.add(grid[i]);
            int[] arr = new int[grid.length];
            for(int j=0;j<grid.length;j++){
                arr[j]=grid[j][i];
            }
            cols.add(arr);
        }
        for(int[] arr1:rows){
            for(int[] arr2:cols){
                if(compareArr(arr1, arr2))
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(equalPairs(grid));
        
    }

}
