/* 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */

import java.util.ArrayList;
import java.util.List;



class InorderTraversal{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverser(list, root);
        return list;
    }
    
    public static void traverser(List<Integer> list,TreeNode root){
        if(root!=null){
            traverser(list, root.left);
            list.add(root.val);
            traverser(list, root.right);
        }
    }
}