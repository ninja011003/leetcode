
public class bst {
    public static void insert(int val,TreeNode root){
        if(root==null){
            root = new TreeNode(val);
            return;
        }
        TreeNode temp  = root;
        if(val>temp.val){
            if(temp.right!=null)
                insert(val, temp.right);
            else
                temp.right= new TreeNode(val);
        }
        if(val<temp.val){
            if(temp.left!=null)
                insert(val, root.left);
            else
                temp.left=new TreeNode(val);
        }

    }


    public static void main(String[] args) {
        Integer[] arr = {2,1,3,4,5,6};
        TreeNode root =new TreeNode(2);
        for(Integer i : arr){
            insert(i, root);
        }
        TreeNode.visualizeBinaryTree(root);
    }
}
