import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
class TreeNode{
    Integer val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer val){
        this.val= val;
        left = right = null;
    }

    public static TreeNode createTree(Integer[] arr){
        if(arr.length==0||arr[0]==null){
            return null;
        }
        TreeNode  root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1;i<arr.length;i+=2){
            TreeNode cur = queue.poll();
            if(arr[i]!=null){
                TreeNode newNode = new TreeNode(arr[i]);
                cur.left = newNode;
                queue.add(newNode);
            }
            else{
                cur.left=null;
            }
            if(i+1==arr.length){
                return root;
            }
            if(arr[i+1]!=null){
                TreeNode newNode = new TreeNode(arr[i+1]);
                cur.right = newNode;
                queue.add(newNode);
            }
            else{
                cur.right = null;
            }
        }
        return root;

    }

    public static void visualizeBinaryTree(TreeNode root) {
        JFrame frame = new JFrame("Binary Tree Visualization");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BinaryTreePanel treePanel = new BinaryTreePanel(root);
        frame.add(treePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static class BinaryTreePanel extends JPanel {
        private final TreeNode root;
        private final int nodeRadius = 25;
        private final int outlineThickness = 5; // Thickness of the outline
        private final int horizontalGap = 100;
        private final int verticalGap = 80;
        private final Color nodeColor = new Color(160, 160, 160); // Slightly Darker Gray
        private final Color edgeColor = Color.black;
        private final Font font = new Font("Arial", Font.BOLD, 20);

        public BinaryTreePanel(TreeNode root) {
            this.root = root;
            setPreferredSize(new Dimension(800, 600));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (root != null) {
                g.setColor(edgeColor);
                drawTree(g, getWidth() / 2, 30, root, getWidth() / 4);
            }
        }

        private void drawTree(Graphics g, int x, int y, TreeNode node, int xOffset) {
            for (int i = 0; i < outlineThickness; i++) {
                g.drawOval(x - nodeRadius - i, y - nodeRadius - i, 2 * (nodeRadius + i), 2 * (nodeRadius + i));
            }

            g.setColor(nodeColor);
            g.fillOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);

            g.setColor(Color.white);
            g.setFont(font);
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(String.valueOf(node.val));
            int textHeight = fm.getHeight();
            g.drawString(String.valueOf(node.val), x - textWidth / 2, y + textHeight / 4);

            if (node.left != null) {
                int nextX = x - xOffset;
                int nextY = y + verticalGap;
                g.setColor(edgeColor);
                drawCurvedLine(g, x, y + nodeRadius, nextX, nextY - nodeRadius);
                drawTree(g, nextX, nextY, node.left, xOffset / 2);
            }

            if (node.right != null) {
                int nextX = x + xOffset;
                int nextY = y + verticalGap;
                g.setColor(edgeColor);
                drawCurvedLine(g, x, y + nodeRadius, nextX, nextY - nodeRadius);
                drawTree(g, nextX, nextY, node.right, xOffset / 2);
            }
        }

        private void drawCurvedLine(Graphics g, int startX, int startY, int endX, int endY) {
            int controlX = (startX + endX) / 2;
            g.drawLine(startX, startY, controlX, startY + (endY - startY) / 2);
            g.drawLine(controlX, startY + (endY - startY) / 2, endX, endY);
        }
    }
}



public class stu_tree {
    public static int max =1;
    public static void findHeight(TreeNode root,int dist){
        if(root!=null){
            if(root.left==null&&root.right==null){
                //leaf node
                max = max>dist?max:dist;
                return;
            }
            if(root.left!=null){
                findHeight(root.left, dist+1);
            }
            if(root.right!=null){
                findHeight(root.right, dist+1);
            }
        }
        return ;
    }

    public static int findHeightRec(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        else{
            int leftH = findHeightRec(root.left);
            int rightH = findHeightRec(root.right);
            return 1 + (leftH>rightH?leftH:rightH);
        }
    }

    public static void preOrderTrav(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+"->");
        preOrderTrav(root.left);
        preOrderTrav(root.right);

    }

    

    public static void inOrderTrav(TreeNode root){
        if(root==null)
            return;
        inOrderTrav(root.left);
        System.out.print(root.val+"->");
        inOrderTrav(root.right);
    }

    public static void postOrderTrav(TreeNode root){
        if(root==null)
            return;
        postOrderTrav(root.left);
        postOrderTrav(root.right);
        System.out.print(root.val+"->");
    }



    

    public static void main(String[] args) {
        Integer[] arr ={1,2,3,4,5,null,null};
        TreeNode root = TreeNode.createTree(arr);
        // TreeNode.visualizeBinaryTree(root);
        // findHeight(root, 1);
        // System.out.println(max);
        // System.out.println(findHeightRec(root));
        preOrderTrav(root);
        System.out.println();
        inOrderTrav(root);
        System.out.println();
        postOrderTrav(root);

    }
}
