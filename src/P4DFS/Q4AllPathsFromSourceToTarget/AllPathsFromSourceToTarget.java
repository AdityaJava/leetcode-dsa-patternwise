package P4DFS.Q4AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> answers = new ArrayList<>();
    List<Integer> tempPath = new ArrayList<>();
    dfs(0, graph, answers, tempPath);
    return answers;
  }

  private void dfs(int index, int[][] graph, List<List<Integer>> answers, List<Integer> tempPath) {
    tempPath.add(index);
    if (index == (graph.length - 1)) {
      answers.add(new ArrayList<>(tempPath));
    }
    for (int i = 0; i < graph[index].length; i++) {
      dfs(graph[index][i], graph, answers, tempPath);
    }
    tempPath.removeLast();
  }

  public static void main(String[] args) {
    int[][] graph = new int[][] { { 1, 2 }, { 3 }, { 3 }, {} };
    //    int[][] graph = new int[][] { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
    AllPathsFromSourceToTarget toTarget = new AllPathsFromSourceToTarget();
    toTarget.allPathsSourceTarget(graph).forEach(System.out::println);
  }
}
