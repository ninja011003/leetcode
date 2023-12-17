/*
 * https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 */
public class LongestConsOnes {
    //my initial approach
    public static int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int max=0,zeros_skipped=0,temp=0;
        while(j<nums.length){
            if(nums[j]==1){
                j++;
            }
            else{
                if(zeros_skipped==0){
                        temp=j;
                }
                if(zeros_skipped<k){
                    j++;
                    zeros_skipped++;
                }
                else{
                    max = Math.max(max, j-i);
                    i=temp+1;
                    j=i;
                    zeros_skipped=0;
                    if(nums.length-j<max){
                        return max;
                    }
                }
            }
        }
        max = Math.max(max, j-i);
        return max;
    }
    //best algo given in editorial sol
    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
    public static void main(String[] args) {
        int[] a={0,0,1,1,1,0,0};
        System.out.println(longestOnes(a, 1));
    }
}
