/*
 * https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// import javax.swing.tree.TreeNode;



public class Deletenode {
    public static TreeNode iniRoot=null;
    public static void DFS(TreeNode root, List<Integer> arr) {
        if (root != null) {
            DFS(root.left, arr);
            arr.add(root.val);
            DFS(root.right, arr);
        }
    }
    private static void insert(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(value);
            } else {
                insert(node.right, value);
            }
        }
    }
    public static TreeNode updatedTree(TreeNode left,TreeNode right){
        List<Integer> arr = new LinkedList<>();
        DFS(left, arr);
        DFS(right, arr);
        if (arr == null || arr.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            insert(root, arr.get(i));
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root.val==key){
            return updatedTree(root.left, root.right);
        }
        else{
            iniRoot = root;
        }
        TreeNode parentNode = root;
        boolean isleft =false;
        while(root!=null){
            if(root.val==key){
                if(isleft){
                    parentNode.left=updatedTree(root.left,root.right);
                }else{
                    parentNode.right =updatedTree(root.left,root.right);
                }
                break;
            }
            else if(root.val>key){
                parentNode=root;
                root=root.left;
                isleft=true;
            }
            else{
                parentNode=root;
                root=root.right;
                isleft=false;
            }
        }
        return iniRoot;
    }
}
