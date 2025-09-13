package P9TopologicalSort.Q3AlienDictonary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ✅ Alien Dictionary – LeetCode Problem Explanation with Cast Example
 *
 * This is a graph problem where you're given a list of words sorted lexicographically according to an alien language's
 * dictionary order, and you need to derive the order of characters in that alien language.
 * 📚 Problem Statement
 * You are given a list of words sorted according to the alien dictionary's order.
 * Return a string of unique characters in the correct order according to the alien language.
 * If there is no valid order or there are cycles, return an empty string "".
 * ✅ Example:
 * Input:
 * ["wrt", "wrf", "er", "ett", "rftt"]
 * Output:
 * "wertf"
 * Explanation:
 * From "wrt" and "wrf", we know 't' comes before 'f'.
 * From "wrt" and "er", 'w' comes before 'e'.
 * From "er" and "ett", 'r' comes before 't'.
 * From "ett" and "rftt", 'e' comes before 'r'.
 * The final order is: "wertf".
 */
public class AlienDictonary {
  public String alienOrder(String[] words) {
    Map<Character, Integer> indegree = new HashMap<>();
    Map<Character, List<Character>> adjacencyMap = new HashMap<>();

  }

  private void createGraph(
    String[] words,
    Map<Character, Integer> indegree,
    Map<Character, List<Character>> adjacencyMap
  ) {
    for (int i = 0; i < words.length - 1; i++) {
      String str1 = words[i];
      String str2 = words[i + 1];
      int str1Ptr = 0, str2Ptr = 0;
      while (str1.charAt(str1Ptr) == str2.charAt(str2Ptr)) {
        str1Ptr++;
        str2Ptr++;
      }
      indegree.put(str2.charAt(str2Ptr), indegree.getOrDefault(str2.charAt(str2Ptr), 0) + 1);
      List<Character> characters = adjacencyMap.getOrDefault(str1.charAt(str1Ptr), new ArrayList<>());
      characters.add(str2.charAt(str2Ptr));
      adjacencyMap.put(str1.charAt(str1Ptr), characters);
    }
  }

  public static void main(String[] args) {

  }
}
