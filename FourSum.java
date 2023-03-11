/*
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.

    

    Example 1:

    Input: nums = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    Example 2:

    Input: nums = [2,2,2,2,2], target = 8
    Output: [[2,2,2,2]]
    

    Constraints:

    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int nums[],int target){
        //two pointer algorithm O(n^2)
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList<>();
        if((target<0&&nums[0]>0)||(target>0&&nums[nums.length-1]<0))
            return ans;
        for(int i=0;i<nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                for(int l=nums.length-1;l>i+2;l--){
                    if(l==nums.length-1||nums[l]!=nums[l+1]){
                        int j=i+1,k=l-1;
                    while(j<k){
                        //System.out.println(nums[i]+","+nums[j]+","+nums[k]+","+nums[l]);
                        //for extreme numbers
                        long sum=(long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
                        if(sum==target){
                            ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            j++;
                            k--;
                            while(j<k&&nums[j]==nums[j-1])
                                j++;
                            while(j<k&&nums[k]==nums[k+1])
                                k--;
                        }
                        else if(sum<target)
                            j++;
                        else
                            k--;
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        //int[] arr = new int[] {1,0,-1,0,-2,2};
        //int[] arr = new int[] {2,2,2,2,2};
        //int[] arr = new int[] {-468,-461,-457,-380,-344,-335,-327,-289,-281,-274,-243,-221,-187,-183,-180,-163,-156,-121,-117,-110,-103,-95,-71,-61,-20,6,17,51,57,69,72,79,81,90,118,130,184,206,231,260,264,333,339,358,364,374,410,427,446,460,466,475};
        //int[] arr = new int[] {1000000000,1000000000,1000000000,1000000000};
        //System.out.println(1000000000+1000000000+1000000000+1000000000);
        int[] arr = new int[] {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        System.out.println(fourSum(arr, 294967296));
    }
}
