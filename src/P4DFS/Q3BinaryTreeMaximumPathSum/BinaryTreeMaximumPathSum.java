package P4DFS.Q3BinaryTreeMaximumPathSum;

import P4DFS.TreeNode;

public class BinaryTreeMaximumPathSum {
  public int maxPathSum(TreeNode root) {
    int[] maxSum = new int[1];
    maxSum[0] = Integer.MIN_VALUE;
    recursiveMaxPathSum(root, maxSum);
    return maxSum[0];
  }

  private int recursiveMaxPathSum(TreeNode node, int[] maxSum) {
    if (node == null) {
      return 0;
    }
    int sum = node.val;
    sum += recursiveMaxPathSum(node.left, maxSum);
    sum += recursiveMaxPathSum(node.right, maxSum);
    maxSum[0] = Math.max(maxSum[0], Math.max(node.val, sum));
    return sum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(-10);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    //    TreeNode root = new TreeNode(2);
    //    root.left = new TreeNode(-1);

    BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
    System.out.println(binaryTreeMaximumPathSum.maxPathSum(root));
  }
}
