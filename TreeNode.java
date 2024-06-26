
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.awt.*;

//definition of TreeNode
/*
 * Author: S.Niranjan
 */
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
    //{1,2,3,4,5}
    public static TreeNode treeCreator(Integer[] arr){
        TreeNode root = new TreeNode(arr[0]);
        TreeNode temp=root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        for(int i=1;i<arr.length;i+=2){
            TreeNode current=queue.poll();
            if(arr[i]!=null){
                TreeNode newNode = new TreeNode(arr[i]);
                current.left= newNode;
                queue.add(newNode);
            }
            else{
                current.left=null;
            }
            if(i+1==arr.length){
                continue;
            }
            if(arr[i+1]!=null){
                TreeNode newNode = new TreeNode(arr[i+1]);
                current.right= newNode;
                queue.add(newNode);
            }
            else{
                current.right=null;
            }
        }
        return root;
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
    public static TreeNode BSTreeCreator(Integer[] arr){
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        return root;
    }

    public static void BFS(TreeNode root,List<Integer> arr){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            arr.add(current.val);
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
        }
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
    public static void main(String[] args) {
        Integer[]  arr ={5,2,6,4,null,null,7};
        visualizeBinaryTree(treeCreator(arr));
    }
}


