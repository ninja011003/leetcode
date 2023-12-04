/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */
public class IncreasingTripetSeq {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second = first;
        for(int num :nums){
            if(num<=first){
                first=num;
            }
            else if(num<=second){
                second=num;
            }
            else{
                System.gc();
                return true;
            }
        }
        return false;
    }
}
