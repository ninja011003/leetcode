/*
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymentricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricPair(root.left, root.right);
    }
    public static boolean isSymmetricPair(TreeNode p, TreeNode q){
        if(p!=null&&q==null||p==null&&q!=null){
            return false;
        }
        else if(p==null&&q==null){
            return true;
        }
        else{
            return p.val==q.val&&isSymmetricPair(p.left, q.right)&&isSymmetricPair(p.right, q.left);
        }
    }
}
