import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {
    public static void traverseLeafs(TreeNode tree,List<Integer> leafs){
        if(tree==null){
            return ;
        }
        else if(tree.left==null&&tree.right==null){
            leafs.add(tree.val);
        }
        else{
            traverseLeafs(tree.left, leafs);
            traverseLeafs(tree.right, leafs);
        }
    }
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        traverseLeafs(root1, arr1);
        traverseLeafs(root2, arr2);
        if(arr1.size()==arr2.size()){
            for(int i=0;i<arr1.size();i++){
                if(!arr1.get(i).equals(arr2.get(i))){
                    // System.out.println(arr1.get(i)+"!="+arr2.get(i));
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(200);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(200);
        TreeNode root1= new TreeNode(2,left,right);
        TreeNode root2= new TreeNode(2,left1,right1);
        System.out.println(leafSimilar(root1, root2));
    }
}
