/*
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedTree {
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(maxTreeDepth(root.left)-maxTreeDepth(root.right))<2){
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        return false;
    }
    public static int maxTreeDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        else if(root.left==null&&root.right==null){
            return 1;
        }
        else if(root.left==null){
            return 1+maxTreeDepth(root.right);
        }
        else if(root.right==null){
            return 1+maxTreeDepth(root.left);
        }
        else{
            return 1+Math.max(maxTreeDepth(root.left),maxTreeDepth(root.right) );
        }
    }
    public static void main(String[] args) {
        
    }
}
