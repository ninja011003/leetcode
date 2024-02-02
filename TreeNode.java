import java.util.List;
//definition of TreeNode
public class TreeNode {
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
    
    public static void preOrderDFS(TreeNode root, List<Integer> arr) {
        if (root != null) {
            arr.add(root.val);
            preOrderDFS(root.left, arr);
            preOrderDFS(root.right, arr);
        }
    }
}
