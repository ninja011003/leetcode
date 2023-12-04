/*
 * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
 */
public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int tot_prod=1;
        for(int i : nums){
            tot_prod*=i;
        }
        int[] ans = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i]==0){
                int temp_ans =1;
                for(int j=0;j<nums.length;j++){
                    if(j!=i){
                        temp_ans*=nums[j];;
                    }
                }
                ans[i]=temp_ans;
            }
            else{
                ans[i]=tot_prod/nums[i];
            }
        }
        return ans;
    }
}
