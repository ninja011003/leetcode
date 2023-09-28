import java.io.*;
import  java.util.*;

public class amazon {
   
    public static int minimumCost(int input1, int[] input2){
        
        computer(0, input2, 0);
        return minCost;
    }
    public static int minCost = Integer.MAX_VALUE;
    public static void computer(int curPosition,int[] input2,int CurCost){
        if(curPosition==input2.length-1){
            if(CurCost<minCost){
                minCost=CurCost;
            }   
        }
        else if(curPosition+3<input2.length){
            computer(curPosition+1, input2, CurCost+Math.abs(input2[curPosition]-input2[curPosition+1]));
            computer(curPosition+3, input2, CurCost+Math.abs(input2[curPosition]-input2[curPosition+3]));
        }
        else if(curPosition+1<input2.length){
            computer(curPosition+1, input2, CurCost+Math.abs(input2[curPosition]-input2[curPosition+1]));
        } 
    }
    public static void main(String[] args) {
        
    }
    

}
