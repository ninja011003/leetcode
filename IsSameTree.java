/*
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * 
*/
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q==null||p==null&&q!=null){
            return false;
        }
        else if(p==null&&q==null){
            return true;
        }
        return p.val==q.val&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
}
