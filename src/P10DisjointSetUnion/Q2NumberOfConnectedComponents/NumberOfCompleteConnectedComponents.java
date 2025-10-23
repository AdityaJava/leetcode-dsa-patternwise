package P10DisjointSetUnion.Q2NumberOfConnectedComponents;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-the-number-of-complete-components/


/**
 * edgesInCompleteComponent= (numberOfNodes×(numberOfNodes−1))/2
 *
 */

class DisjointSet {
  List<Integer> parent;
  List<Integer> size;

  public DisjointSet(int n) {
    parent = new ArrayList<>();
    size = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      parent.add(i);
      size.add(1);
    }
  }

  public int findUltimateParent(int x) {
    if (parent.get(x) != x) {
      parent.set(x, findUltimateParent(parent.get(x)));
    }
    return parent.get(x);
  }

  public void unionBySize(int x, int y) {
    int ultimateParentOfX = findUltimateParent(x);
    int ultimateParentOfY = findUltimateParent(y);
    if (ultimateParentOfX == ultimateParentOfY) {
      return;
    }
    if (size.get(ultimateParentOfX) > size.get(ultimateParentOfY)) {
      parent.set(ultimateParentOfY, ultimateParentOfX);
      size.set(ultimateParentOfX, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
    }
    else {
      parent.set(ultimateParentOfX, ultimateParentOfY);
      size.set(ultimateParentOfY, size.get(ultimateParentOfX) + size.get(ultimateParentOfY));
    }
  }

  public int getCompleteComponents() {
    return (int) parent.stream().distinct().count();
  }

}

public class NumberOfCompleteConnectedComponents {

  public int countCompleteComponents(int n, int[][] edges) {

    DisjointSet disjointSet = new DisjointSet(n);
    for (int[] edge : edges) {
      disjointSet.unionBySize(edge[0], edge[1]);
    }
    return disjointSet.getCompleteComponents();
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {
      { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }
    };
    NumberOfCompleteConnectedComponents connectedComponents = new NumberOfCompleteConnectedComponents();
    System.out.println(connectedComponents.countCompleteComponents(n, edges));

  }
}
