package P4DFS.Q1PathSum;

import P4DFS.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/description/
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There are two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 */
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
