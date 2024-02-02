/*
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 * I had wasted about 3 days of my time solving a problem without understanding the question properly!
 */

import java.util.LinkedList;
import java.util.List;

public class GoodOnes {
    public static int goodNodes(TreeNode root,int max){
        if(root!=null){
            if(root.val>=max){
                return 1+ goodNodes(root.left,root.val)+goodNodes(root.right,root.val);
            }
            else{
                return goodNodes(root.left,max)+goodNodes(root.right,max);
            }
        }
        return 0;
    }
    
    public static int goodNodes(TreeNode root) {
        return goodNodes(root,root.val);
    }

}
