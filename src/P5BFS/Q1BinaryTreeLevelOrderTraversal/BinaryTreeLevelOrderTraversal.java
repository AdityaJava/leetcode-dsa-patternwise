package P5BFS.Q1BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import P4DFS.TreeNode;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.EMPTY_LIST;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    List<Integer> currentLevel = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      currentLevel = new ArrayList<>();
      for (int i = 0; i < queueSize; i++) {
        TreeNode temp = queue.poll();
        currentLevel.add(temp.val);
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
      result.add(currentLevel);
    }
    return result;
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

    BinaryTreeLevelOrderTraversal b1 = new BinaryTreeLevelOrderTraversal();

    System.out.println(b1.levelOrder(root));

  }
}
