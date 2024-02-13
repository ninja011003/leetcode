/*
 * https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;  
import java.util.Queue;







// import javax.swing.tree.TreeNode;





public class BinTreeRightView{
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        List<TreeNode> curLvl = new LinkedList<>();
        if(root!=null){
            curLvl.add(root);
        }
        while(!curLvl.isEmpty()){
            ans.add(curLvl.get(curLvl.size()-1).val);
            List<TreeNode> nxtLvl = new LinkedList<>();
            for(TreeNode node : curLvl){
                if(node.left!=null){
                    nxtLvl.add(node.left);
                }
                if(node.right!=null){
                    nxtLvl.add(node.right);
                }
            }
            curLvl=nxtLvl;

        }
        return ans;
    }
    
    public static void main(String[] args) {
        Integer[] arr ={6,1,null,null,3,2,5,null,null,4};
        List<Integer> list1 = new ArrayList<>();
        TreeNode root = TreeNode.treeCreator(arr);
        TreeNode.visualizeBinaryTree(root);
        List<Integer> l = new ArrayList<>();
        TreeNode.BFS(root,l);
        for(Integer i: l){
            System.out.print(i+"-");
        }
        System.out.println();
        List<Integer> ans =rightSideView(root);
       
        for(Integer i: ans){
            System.out.print(i+"-");
        }
       
    }
}

