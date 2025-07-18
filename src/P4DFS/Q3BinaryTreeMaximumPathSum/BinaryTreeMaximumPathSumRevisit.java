package P4DFS.Q3BinaryTreeMaximumPathSum;

import com.sun.source.tree.Tree;

import P4DFS.TreeNode;

//Not working
public class BinaryTreeMaximumPathSumRevisit {
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    recursiveMaxPath(root);
    return max;
  }

  public int recursiveMaxPath(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = Math.max(recursiveMaxPath(node.left), 0);
    int right = Math.max(recursiveMaxPath(node.right), 0);
    int max1 = Math.max(left, right);
    max = Math.max(max, Math.max(node.val + max1, node.val + right + left));
    return node.val + max1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(-2);
    root.right = new TreeNode(3);

    //    TreeNode root = new TreeNode(1);
    //    root.left = new TreeNode(2);
    //    root.right = new TreeNode(3);

    //    TreeNode root = new TreeNode(-3);

    BinaryTreeMaximumPathSumRevisit revisit = new BinaryTreeMaximumPathSumRevisit();
    System.out.println(revisit.maxPathSum(root));
  }
}
