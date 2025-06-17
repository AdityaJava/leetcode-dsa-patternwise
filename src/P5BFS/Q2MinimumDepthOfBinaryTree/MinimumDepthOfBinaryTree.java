package P5BFS.Q2MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import P4DFS.TreeNode;

public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      level++;
      for (int i = 0; i < queueSize; i++) {
        TreeNode temp = queue.poll();
        if (temp.right == null && temp.left == null) {
          return level;
        }

        if (temp.left != null) {
          queue.add(temp.left);
        }

        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
    return level;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode n1 = new TreeNode(9);
    TreeNode n2 = new TreeNode(20);
    root.left = n1;
    root.right = n2;

    TreeNode n3 = new TreeNode(15);
    TreeNode n4 = new TreeNode(7);
    n2.left = n3;
    n2.right = n4;

    MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
    System.out.println(minimumDepthOfBinaryTree.minDepth(root));
  }
}
