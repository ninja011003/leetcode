/*
 * https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        //worst time complexity 
        int i=0,j=nums.length-1;
        if(nums.length==1){
            return;
        }
        while(i<j){
            if(nums[i]==0){
                int k=i;
                while(k<j){
                    int temp=nums[k];
                    nums[k]=nums[k+1];
                    nums[k+1]=temp;
                    k++;
                }
                j--;
            }
            else{
                i++;
            }
        }
        //snowball approach
        // https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation/?envType=study-plan-v2&envId=leetcode-75
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}
