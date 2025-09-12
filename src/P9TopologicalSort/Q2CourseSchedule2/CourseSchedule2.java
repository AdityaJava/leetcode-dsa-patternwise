package P9TopologicalSort.Q2CourseSchedule2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule2 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> indegree = new HashMap<>();
    Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      indegree.put(i, 0);
      adjacencyMap.put(i, new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int course = prerequisites[i][0];
      int preReq = prerequisites[i][1];
      indegree.put(course, indegree.get(course) + 1);
      adjacencyMap.get(preReq).add(course);
    }

    Queue<Integer> queue = new LinkedList<>();
    int[] result = new int[numCourses];
    int i = 0;

    for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
      if (entry.getValue() == 0) {
        result[i++] = entry.getKey();
        queue.add(entry.getKey());
      }
    }

    int numberOfCoursesProcessed = 0;
    while (!queue.isEmpty()) {
      Integer preq = queue.poll();
      numberOfCoursesProcessed++;
      for (int neighbour : adjacencyMap.get(preq)) {
        indegree.put(neighbour, indegree.get(neighbour) - 1);
        if (indegree.get(neighbour) == 0) {
          result[i++] = neighbour;
          queue.add(neighbour);
        }
      }
    }
    if (numberOfCoursesProcessed == numCourses) {
      return result;
    }
    return new int[0];
  }

  public static void main(String[] args) {
    //    int numCourses = 4;
    //    int[][] prerequisites = {
    //      { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 }
    //    };

    int numCourses = 2;
    int[][] prerequisites = {

    };

    CourseSchedule2 courseSchedule2 = new CourseSchedule2();
    Arrays.stream(courseSchedule2.findOrder(numCourses, prerequisites)).forEach(System.out::println);
  }
}






















