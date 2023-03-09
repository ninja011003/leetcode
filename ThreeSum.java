import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        /* *
        //bruteforce method O(n^3)
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> subList = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(subList);
                        if(!set.contains(subList)){
                            set.add(subList);
                            ans.add(subList);
                        }
                    }
                }
            }
        }
        return ans;
        */
        //two pointer algorithm O(n^2)
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2&&nums[i]<=0;i++){
            if(i==0||nums[i]!=nums[i-1]){
                int j=i+1,k=nums.length-1;
                while(j<k){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(sum==0){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;
                        while(j<k&&nums[j]==nums[j-1])
                            j++;
                        while(j<k&&nums[k]==nums[k+1])
                            k--;
                    }
                    else if(sum<0)
                        j++;
                    else
                        k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
