package P9TopologicalSort.Q4MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Final note
 *
 * Equivalent formulation: find the centroid(s) of the tree. There is no simpler closed-form numeric
 * formula for the count other than the property “at most two” — you must inspect structure
 * (or run the leaf-peeling) to know whether it’s 1 or 2 for a given tree.
 */
public class MinimumHeightTrees {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Map<Integer, Integer> degrees = new HashMap<>();
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    createGraph(degrees, adjacencyList, edges, n);
    Queue<Integer> queue = new LinkedList<>();
    int numberOfNodes = n;
    for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
      if (entry.getValue() <= 1) {
        queue.add(entry.getKey());
      }
    }
    int numberOfNodesProcessed = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      if ((numberOfNodes - numberOfNodesProcessed) <= 2) {
        break;
      }
      for (int i = 0; i < size; i++) {
        int key = queue.poll();
        for (int neighbour : adjacencyList.get(key)) {
          degrees.put(neighbour, degrees.get(neighbour) - 1);
          if (degrees.get(neighbour) == 1) {
            queue.add(neighbour);
          }
        }
      }
      numberOfNodesProcessed += size;
    }
    return new ArrayList<>(queue);
  }

  private void createGraph(
    Map<Integer, Integer> degree,
    Map<Integer, List<Integer>> adjacencyList,
    int[][] edges,
    int n
  ) {
    for (int i = 0; i < n; i++) {
      degree.put(i, 0);
      adjacencyList.put(i, new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      int e1 = edges[i][0];
      int e2 = edges[i][1];
      degree.put(e1, degree.get(e1) + 1);
      degree.put(e2, degree.get(e2) + 1);
      adjacencyList.computeIfAbsent(e1, k -> new ArrayList<>()).add(e2);
      adjacencyList.computeIfAbsent(e2, k -> new ArrayList<>()).add(e1);
    }
  }

  public static void main(String[] args) {
    //    int n = 6;
    //    int[][] edges = {
    //      { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 }
    //    };
    int n = 1;
    int[][] edges = {};
    MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
    minimumHeightTrees.findMinHeightTrees(n, edges).forEach(System.out::println);
  }
}
