/*
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class longestSubArray {
    public static int longestSubarray(int[] nums) {
        int flag=1,temp=0,max=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else if(flag==1){
                temp=i;
                flag=0;
            }
            else if(count>max){
                max=count;
                count=0;
                i=temp;
                flag=1;
            }
            else{
                count=0;
                i=temp;
                flag=1;
            }
        }
        if(Math.max(max,count)==nums.length){
            return nums.length-1;
        }
        return Math.max(max,count);
    }
    public static void main(String[] args) {
        
    }
}
