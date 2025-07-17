package P4DFS.Q3BinaryTreeMaximumPathSum;

import com.sun.source.tree.Tree;

import P4DFS.TreeNode;

//Not working
public class BinaryTreeMaximumPathSumRevisit {

  public int maxPathSum(TreeNode root) {
    return recursiveMaxPath(root);
  }

  public int recursiveMaxPath(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftSum = recursiveMaxPath(node.left);
    int rightSum = recursiveMaxPath(node.right);
    int max1 = Math.max(node.val, Math.max(leftSum, rightSum));

    int max2 = Math.max(node.val + rightSum, node.val + leftSum);
    int sumAll = node.val + leftSum + rightSum;

    return Math.max(sumAll, Math.max(max1, max2));
  }

  public static void main(String[] args) {
    //    TreeNode root = new TreeNode(1);
    //    root.left = new TreeNode(-2);
    //    root.right = new TreeNode(3);

    //    TreeNode root = new TreeNode(1);
    //    root.left = new TreeNode(2);
    //    root.right = new TreeNode(3);

    TreeNode root = new TreeNode(-3);

    BinaryTreeMaximumPathSumRevisit revisit = new BinaryTreeMaximumPathSumRevisit();
    System.out.println(revisit.maxPathSum(root));
  }
}
