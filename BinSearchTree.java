public class BinSearchTree {
    TreeNode root;
    BinSearchTree(){
        root=null;
    }
    BinSearchTree(int val){
        root = new TreeNode(val);
    }
    private void insert(int val,TreeNode node){
        TreeNode temp = node;
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
    public void insert(int val){
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
}
