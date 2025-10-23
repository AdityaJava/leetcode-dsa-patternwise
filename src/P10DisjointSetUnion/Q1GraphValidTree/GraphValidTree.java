package P10DisjointSetUnion.Q1GraphValidTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 261. Graph Valid Tree
 *
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an array of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi.
 *
 * A graph is a tree if:
 *
 * It is connected — there is a path between any two nodes.
 *
 * It has no cycles.
 *
 * Return true if the given edges make up a valid tree, and false otherwise.
 *
 * Q1 -> n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Ans: True
 *
 * Q2 -> n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Ans: False
 */
class DisJointSet {
  List<Integer> size;
  List<Integer> parent;

  public DisJointSet(int n) {
    size = new ArrayList<>();
    parent = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      size.add(1);
      parent.add(i);
    }
  }

  public int findUltimateParent(int x) {
    if (parent.get(x) != x) {
      parent.set(x, findUltimateParent(parent.get(x)));
    }
    return parent.get(x);
  }

  public boolean unionBySize(int x, int y) {
    int ultimateParentOfX = findUltimateParent(x);
    int ultimateParentOfY = findUltimateParent(y);

    // This means that cycle exists
    if (ultimateParentOfY == ultimateParentOfX) {
      return false;
    }

    if (size.get(ultimateParentOfX) > size.get(ultimateParentOfY)) {
      parent.set(ultimateParentOfY, ultimateParentOfX);
      size.set(ultimateParentOfX, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
    }
    else {
      parent.set(ultimateParentOfX, ultimateParentOfY);
      size.set(ultimateParentOfY, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
    }
    return true;
  }

}

public class GraphValidTree {
  /**
   * Tree Property
   *
   * For a graph with n nodes:
   *
   * A tree is a connected and acyclic graph.
   *
   * Therefore, a tree must have exactly n - 1 edges.
   *
   * If:
   *
   * Edges < n - 1 → Graph is disconnected (not all nodes connected).
   *
   * Edges > n - 1 → Graph has a cycle (too many connections).
   *
   * So before doing any cycle or connectivity check,
   * 👉 we can immediately reject the graph if edges.length != n - 1.
   */
  public boolean validTree(int n, int[][] edges) {
    DisJointSet disJointSet = new DisJointSet(n);

    if (edges.length != n - 1) {
      return false;
    }
    for (int row = 0; row < edges.length; row++) {
      if (!disJointSet.unionBySize(edges[row][0], edges[row][1])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    GraphValidTree graphValidTree = new GraphValidTree();

    int n1 = 5;
    int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
    System.out.println(graphValidTree.validTree(n1, edges1)); // true

    int n2 = 5;
    int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
    System.out.println(graphValidTree.validTree(n2, edges2)); // false

  }
}
