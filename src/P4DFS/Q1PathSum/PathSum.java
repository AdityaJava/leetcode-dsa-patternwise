package P4DFS.Q1PathSum;

import P4DFS.TreeNode;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return checkPathSumRecursively(root, targetSum, 0);
  }

  private boolean checkPathSumRecursively(TreeNode node, int targetSum, int sum) {
    if (node != null) {
      sum = sum + node.val;
    }
    if (node != null && node.left == null && node.right == null) {
      return sum == targetSum;
    }
    else if (node != null) {
      boolean result = false;
      result = checkPathSumRecursively(node.left, targetSum, sum);
      if (result) {
        return true;
      }
      return checkPathSumRecursively(node.right, targetSum, sum);
    }
    return false;
  }

  public static void main(String[] args) {
    //    TreeNode rootNode = new TreeNode(5);
    //    TreeNode node1 = new TreeNode(4);
    //    TreeNode node2 = new TreeNode(8);
    //
    //    rootNode.left = node1;
    //    rootNode.right = node2;
    //
    //    TreeNode node3 = new TreeNode(11);
    //    node1.left = node3;
    //
    //    TreeNode node4 = new TreeNode(13);
    //    TreeNode node5 = new TreeNode(4);
    //    node2.left = node4;
    //    node2.right = node5;
    //
    //    TreeNode node6 = new TreeNode(7);
    //    TreeNode node7 = new TreeNode(2);
    //    node3.left = node6;
    //    node3.right = node7;
    //
    //    TreeNode node8 = new TreeNode(1);
    //    node5.right = node8;

    TreeNode rootNode = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    rootNode.left = node1;

    PathSum pathSum = new PathSum();
    System.out.println(pathSum.checkPathSumRecursively(rootNode, 0, 0));
  }
}
