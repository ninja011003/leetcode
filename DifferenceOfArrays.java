/*
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceOfArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();
        Set<Integer> set1= new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        for(int i :nums1){
            set1.add(i);
        }
        for(int i :nums2){
            set2.add(i);
        }
        for(int i : set1){
            if(!set2.contains(i)){
                diff1.add(i);
            }
        }
        ans.add(diff1);
        for(int i : set2){
            if(!set1.contains(i)){
                diff2.add(i);
            }
        }
        ans.add(diff2);
        return ans;
    }
}
