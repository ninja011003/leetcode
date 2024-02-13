/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 */



public class LowestCommonAncestor {
    TreeNode LCA = null;
    public boolean isConnected(TreeNode node,TreeNode subnode){
        if(node!=null){
            if(node.val==subnode.val){
                return true;
            }
            else{
                return isConnected(node.right, subnode)||isConnected(node.left, subnode);
            }
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isConnected(p, q)){
            return p;
        }
        else if(isConnected(q, p)){
            return q;
        }
        else{
            while(isConnected(root, p)&&isConnected(root, q)){
                LCA= root;
                if(isConnected(root.right, p)&&isConnected(root.right, q)){
                    root=root.right;
                }
                else{
                    root=root.left;
                }
            }
            return LCA;
        }
    }

}
