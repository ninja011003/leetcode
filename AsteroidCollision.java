/*
 * https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans= new ArrayList<>();
        for(int i=asteroids.length-1;i>0;i--){
            if((asteroids[i]<0&&asteroids[i-1]<0)||(asteroids[i]>0&&asteroids[i-1]>0))
                continue;
            else if(asteroids[i]>0&&asteroids[i-1]<0){
                continue;
            }
            else{
                int a =Math.abs(asteroids[i]),b=Math.abs(asteroids[i-1]);
                if(a==b){
                    asteroids[i]=0;
                    asteroids[i-1]=0;
                    i--;
                }
                else{
                    asteroids[i-1]= ((a>b) ? asteroids[i]:asteroids[i-1]);
                    asteroids[i]=0;
                }
            }
        }
        
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]!=0)
                ans.add(asteroids[i]);
        }
        if(ans.stream().mapToInt(Integer::intValue).toArray().length==asteroids.length){
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
        return asteroidCollision(ans.stream().mapToInt(Integer::intValue).toArray());
    }
    public static void main(String[] args) {
        int[] a={-2,1,-2,-2};
        asteroidCollision(a);
    }
}
