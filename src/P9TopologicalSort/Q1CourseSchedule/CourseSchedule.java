package P9TopologicalSort.Q1CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> inDegree = new HashMap<>();
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    //1. Init AdjacencyList and inDegree
    for (int i = 0; i < numCourses; i++) {
      adjacencyList.put(i, new ArrayList<>());
    }

    //2. Create
    for (int i = 0; i < prerequisites.length; i++) {
      int course = prerequisites[i][0];
      int preReq = prerequisites[i][1];
      inDegree.put(course, inDegree.getOrDefault(course, 0) + 1);
      adjacencyList.getOrDefault(preReq, new ArrayList<>()).add(course);
    }
    return false;
  }


  public static void main(String[] args) {
    int numCourses = 6;
    int[][] prerequisites = { { 1, 0 }, { 1, 2 }, { 3, 1 }, { 2, 3 }, { 2, 4 }, { 4, 5 }, { 2, 5 } };
    CourseSchedule courseSchedule = new CourseSchedule();
    courseSchedule.canFinish(numCourses, prerequisites);
  }
}
