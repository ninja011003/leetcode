/*
 * https://leetcode.com/problems/path-sum-iii/?envType=study-plan-v2&envId=leetcode-75
 */



public class PathSum {
    // public static int pathSum(TreeNode root, int targetSum,int iniNum) {
    //     if(root!=null){
    //         if(targetSum==root.val){
    //             return 1+pathSum(root.left, iniNum)+pathSum(root.right, iniNum);
    //         }
    //         else{
    //             return pathSum(root.left, targetSum-root.val)+pathSum(root.right, targetSum-root.val)+pathSum(root.left, iniNum)+pathSum(root.right, iniNum);
    //         }
    //     }
    //     return 0;
    // }
    // public static int pathSum(TreeNode root, int targetSum) {
    //     return pathSum(root, targetSum, targetSum);
    // }
    public static int count=0;
    public static int pathSum(TreeNode root, int targetSum) {
        if(root!=null){
            pathSum(root, targetSum, 0);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return count;
        }
        return 0;
    }
    public static void pathSum(TreeNode root,int targetSum,int currentSum){
        if(root==null){
            return;
        }
        if(Integer.MAX_VALUE-Math.abs(currentSum)<Math.abs(root.val)){
            return;
        }
        currentSum+=root.val;
        if(currentSum==targetSum){
            count++;
        }
        pathSum(root.left, targetSum,currentSum);
        pathSum(root.right, targetSum,currentSum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null,new TreeNode(2));
        System.out.println(pathSum(root, 2));
    }
}
