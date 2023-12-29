/*
 * https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
public class UniqueOccurance {
    public boolean uniqueOccurrences(int[] arr) {
        /* 
        HashMap<Integer,Integer> uniqOcc = new HashMap<>();
        for(int i : arr){
            if(uniqOcc.containsKey(i)){
                uniqOcc.put(i, uniqOcc.get(i)+1);
            }
            else{
                uniqOcc.put(i, 1);
            }
        }
        Set<Integer> ans = new HashSet<>();
        for(int i : uniqOcc.values()){
            if(ans.contains(i)){
                return false;
            }else{
                ans.add(i);
            }
        }
        return true;
        */
        //another method
        Arrays.sort(arr);
        Set<Integer> ans = new HashSet<>();
        int count =1;
        if(arr.length==2&&arr[0]!=arr[1]){
            return false;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
            }
            else{
                if(ans.contains(count))
                    return false;
                else{
                    ans.add(count);
                    count=1;
                }
            }
        }
        if(arr[arr.length-1]!=arr[arr.length-2]&&ans.contains(1)){
            return false;   
        }
        return true;
    }
}
