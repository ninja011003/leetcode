/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class ConvertArrToTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root =null;
        if(nums.length>0){
            int mid= nums.length/2;
            root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, 0, mid-1);
            root.right = sortedArrayToBST(nums, mid+1, nums.length-1);
        }else{
            root = new TreeNode(nums[0]);
        }
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] nums,int low,int high) {
        TreeNode root =null;
        if((high-low+1)>0){
            int mid= low + (high-low)/2;
            root = new TreeNode(nums[mid]);
            /*
             * mid-1 creates -1 values which results in repeating node error
             * in line 27
             */
            root.left = sortedArrayToBST(nums, low, mid-1); //line 27
            root.right  = sortedArrayToBST(nums, mid+1, high);
        }else{
            root = new TreeNode(nums[0]);
        }
        return root;
    }
    public static void main(String[] args) {
        int[] a ={-10,-3,0,5,9};
        sortedArrayToBST(a);
    }
}
