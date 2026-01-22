package P4DFS.Q4AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, result, temp, graph);
        return result;
    }

    private void dfs(int startPoint, List<List<Integer>> result, List<Integer> temp, int[][] graph) {
        temp.add(startPoint);
        if (startPoint == graph.length - 1) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < graph[startPoint].length; i++) {
            dfs(graph[startPoint][i], result, temp, graph);
        }
        temp.removeLast();
    }

    public static void main(String[] args) {

    }
}
