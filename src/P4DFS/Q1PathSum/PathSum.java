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
    //    P4DFS.TreeNode rootNode = new P4DFS.TreeNode(5);
    //    P4DFS.TreeNode node1 = new P4DFS.TreeNode(4);
    //    P4DFS.TreeNode node2 = new P4DFS.TreeNode(8);
    //
    //    rootNode.left = node1;
    //    rootNode.right = node2;
    //
    //    P4DFS.TreeNode node3 = new P4DFS.TreeNode(11);
    //    node1.left = node3;
    //
    //    P4DFS.TreeNode node4 = new P4DFS.TreeNode(13);
    //    P4DFS.TreeNode node5 = new P4DFS.TreeNode(4);
    //    node2.left = node4;
    //    node2.right = node5;
    //
    //    P4DFS.TreeNode node6 = new P4DFS.TreeNode(7);
    //    P4DFS.TreeNode node7 = new P4DFS.TreeNode(2);
    //    node3.left = node6;
    //    node3.right = node7;
    //
    //    P4DFS.TreeNode node8 = new P4DFS.TreeNode(1);
    //    node5.right = node8;

    TreeNode rootNode = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    rootNode.left = node1;

    PathSum pathSum = new PathSum();
    System.out.println(pathSum.checkPathSumRecursively(rootNode, 0, 0));
  }
}
