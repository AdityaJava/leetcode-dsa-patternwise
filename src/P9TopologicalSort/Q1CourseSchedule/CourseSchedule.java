package P9TopologicalSort.Q1CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> inDegree = new HashMap<>();
    Map<Integer, List<Integer>> adjacencyListMap = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      inDegree.put(i, 0);
      adjacencyListMap.put(i, new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int course = prerequisites[i][0];
      int preReq = prerequisites[i][1];
      inDegree.put(course, inDegree.getOrDefault(course, 0) + 1);
      adjacencyListMap.get(preReq).add(course);
    }

    Queue<Integer> queue = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        queue.add(entry.getKey());
      }
    }
    int processedCourses = 0;

    while (!queue.isEmpty()) {
      Integer preReq = queue.poll();
      processedCourses++;
      for (Integer neighbour : adjacencyListMap.get(preReq)) {
        inDegree.put(neighbour, inDegree.get(neighbour) - 1);
        if (inDegree.get(neighbour) == 0) {
          queue.add(neighbour);
        }
      }
    }
    return processedCourses == numCourses;
  }


  public static void main(String[] args) {
    //    int numCourses = 6;
    //    int[][] prerequisites = { { 1, 0 }, { 1, 2 }, { 3, 1 }, { 2, 3 }, { 2, 4 }, { 4, 5 }, { 2, 5 } };
    int numCourses = 2;
    int[][] prerequisites = { { 1, 0 } };
    CourseSchedule courseSchedule = new CourseSchedule();

    System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
  }
}
