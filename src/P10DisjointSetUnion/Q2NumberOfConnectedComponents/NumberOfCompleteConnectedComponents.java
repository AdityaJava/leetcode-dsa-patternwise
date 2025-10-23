package P10DisjointSetUnion.Q2NumberOfConnectedComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/count-the-number-of-complete-components/


/**
 * edgesInCompleteComponent= (numberOfNodes×(numberOfNodes−1))/2
 */

class DisjointSet {
  List<Integer> parentList;
  List<Integer> sizeList;

  public DisjointSet(int n) {
    parentList = new ArrayList<>();
    sizeList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      parentList.add(i);
      sizeList.add(1);
    }
  }

  public int findUltimateParent(int x) {
    if (parentList.get(x) != x) {
      parentList.set(x, findUltimateParent(parentList.get(x)));
    }
    return parentList.get(x);
  }

  public void unionBySize(int x, int y) {
    int ultimateParentOfX = findUltimateParent(x);
    int ultimateParentOfY = findUltimateParent(y);
    if (ultimateParentOfX == ultimateParentOfY) {
      return;
    }
    if (sizeList.get(ultimateParentOfX) > sizeList.get(ultimateParentOfY)) {
      parentList.set(ultimateParentOfY, ultimateParentOfX);
      sizeList.set(ultimateParentOfX, sizeList.get(ultimateParentOfX) + sizeList.get(ultimateParentOfY));
    }
    else {
      parentList.set(ultimateParentOfX, ultimateParentOfY);
      sizeList.set(ultimateParentOfY, sizeList.get(ultimateParentOfX) + sizeList.get(ultimateParentOfY));
    }
  }

  public int getCompleteComponents(int[][] edges, int n) {
    int completeComponents = 0;
    Map<Integer, Integer> parentToEdgeCount = new HashMap<>();
    for (int[] edge : edges) {
      int parent = findUltimateParent(edge[0]);
      parentToEdgeCount.put(parent, parentToEdgeCount.getOrDefault(parent, 0) + 1);
    }
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int parent = findUltimateParent(i);
      if (!visited.contains(parent)) {
        int size = sizeList.get(parent);
        int edgeCount = parentToEdgeCount.containsKey(parent) ? parentToEdgeCount.get(parent) : 1;
        visited.add(parent);

        // * edgesInCompleteComponent= (numberOfNodes×(numberOfNodes−1))/2
        boolean condition = size != 1 ? (size * (size - 1)) / 2 == edgeCount : true;
        if (condition) {
          completeComponents++;
        }
      }
    }
    return completeComponents;
  }

}

public class NumberOfCompleteConnectedComponents {

  public int countCompleteComponents(int n, int[][] edges) {

    DisjointSet disjointSet = new DisjointSet(n);
    for (int[] edge : edges) {
      disjointSet.unionBySize(edge[0], edge[1]);
    }
    return disjointSet.getCompleteComponents(edges, n);
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {
      { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }, { 3, 5 }
    };

    //    int n = 6;
    //
    //    int[][] edges = {
    //      { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }
    //    };

    //    int n = 4;
    //    int[][] edges = { { 2, 0 }, { 3, 1 }, { 3, 2 } };
    NumberOfCompleteConnectedComponents connectedComponents = new NumberOfCompleteConnectedComponents();
    System.out.println(connectedComponents.countCompleteComponents(n, edges));

  }
}
