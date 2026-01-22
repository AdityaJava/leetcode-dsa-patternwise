package P4DFS.Q3BinaryTreeMaximumPathSum;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

import P4DFS.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Max path we can take from left & right child
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Best path that passes through this node
        int priceAtNode = node.val + leftGain + rightGain;

        // Update global max
        max = Math.max(max, priceAtNode);

        // Return best single-side path to parent
        return node.val + Math.max(leftGain, rightGain);
    }


    public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);

        //    TreeNode root = new TreeNode(1);
        //    root.left = new TreeNode(2);
        //    root.right = new TreeNode(3);

        //    TreeNode root = new TreeNode(-3);

//ex
//        TreeNode root = new TreeNode(-8);
//        root.left = new TreeNode(2);
//
//        TreeNode right1 = new TreeNode(20);
//        right1.left = new TreeNode(15);
//        right1.right = new TreeNode(7);
//        root.right = right1;

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);

        TreeNode right1 = new TreeNode(20);
        right1.left = new TreeNode(15);
        right1.right = new TreeNode(7);
        root.right = right1;

        BinaryTreeMaximumPathSum revisit = new BinaryTreeMaximumPathSum();
        System.out.println(revisit.maxPathSum(root));
    }
}
