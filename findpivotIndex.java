/*
 * https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75
 */
public class findpivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        int left=0,right=sum;
        if(left==right-nums[0])
            return 0;
        right-=nums[0];
        for(int i=0;i<nums.length-1;i++){
            left+=nums[i];
            right-=nums[i+1];
            if(left==right){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a={1,7,3,6,5,6};
        System.out.println(pivotIndex(a));
    }
}
