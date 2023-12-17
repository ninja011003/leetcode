public class MaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        int total=0;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        max = total;
        for(int i=1;i<=nums.length-k;i++){
            total=total-nums[i-1]+nums[i+k-1];
            if(total>max){
                max=total;
            }
        }
        return (double)max/k;
    }
}
