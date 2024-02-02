/*
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class LongestZigZag {
    int count =0;
    public int longestZigZag(TreeNode root) {
        if(root!=null){
            longestZigZag(root.right, 'r', 0);
            longestZigZag(root.left, 'l', 0);
            return count;
        }
        return 0;
    }
    public void longestZigZag(TreeNode root,char direction,int curLength){
        if(root!=null){
            if(direction=='r'){
                longestZigZag(root.left, 'l', curLength+1);
                longestZigZag(root.right,'r',0);
            }
            else{
                longestZigZag(root.right, 'r', curLength+1);
                longestZigZag(root.left,'l',0);
            }
        }
        else{
            if(curLength>count){
                count=curLength;
            }
        }
    }
}
