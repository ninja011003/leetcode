public class sample {
    public static void main(String[] args) {

        BinSearchTree bst = new BinSearchTree(40);
        Integer[] arr ={20,60,10,30,50,70};
        for(Integer i : arr){
            bst.insert(i);
        }
        
        TreeNode.visualizeBinaryTree(bst.root);
    }
}
