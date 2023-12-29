/*
 * https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
 */
public class largestAltitude {
    public int largestAltitude(int[] gain) {
        int max=Integer.MIN_VALUE;
        int curHeight=0;
        for(int i : gain){
            curHeight+=i;
            max = (curHeight>max)?curHeight:max;
        }
        return (max>0)?max:0;
    }
}
