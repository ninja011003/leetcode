/*
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
public class maxLevelSum {
    public int maxLevelSum(TreeNode root) {
        List<TreeNode> curLvl = new LinkedList<>();
        int max = Integer.MIN_VALUE,lvl=0,k=0;
        if(root!=null){
            curLvl.add(root);
        }
        while(!curLvl.isEmpty()){
            int temp =0;
            List<TreeNode> nxtLvl = new LinkedList<>();
            for(TreeNode node : curLvl){
                temp+=node.val;
                if(node.right!=null){
                    nxtLvl.add(node.right);
                }
                if(node.left!=null){
                    nxtLvl.add(node.left);
                }
                
            }
            if(temp>max){
                max=temp;
                lvl=k;
            }
            curLvl=nxtLvl;
            k++;
        }
        return lvl;
    }
}
