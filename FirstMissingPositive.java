import java.util.*;
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        boolean[] contains = new boolean[nums.length];
        for(int i:nums){
            if(i<nums.length&&i>0){
                contains[i-1]=true;
            }
        }
        for(int i=0;i<contains.length;i++){
            if(!contains[i]){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void main(String[] args) {
        int[] a={1,2,3};
        firstMissingPositive(a);
    }
} 
