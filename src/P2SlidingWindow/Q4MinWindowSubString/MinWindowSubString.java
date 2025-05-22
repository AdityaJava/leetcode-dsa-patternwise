package P2SlidingWindow.Q4MinWindowSubString;

//https://leetcode.com/problems/minimum-window-substring/?envType=problem-list-v2&envId=sliding-window

import java.util.HashMap;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */

public class MinWindowSubString {
  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    int left = 0;
    int right = 0;
    int minLength = Integer.MAX_VALUE;
    int length = 0;
    HashMap<Character, Integer> sMap = new HashMap<>();
    String result = "";

    for (right = 0; right < s.length(); right++) {
      sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
      length++;
      while (matches(tMap, sMap)) {
        if (minLength > length) {
          minLength = length;
          result = s.substring(left, left + minLength);
        }
        sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
        if (sMap.get(s.charAt(left)) == 0) {
          sMap.remove(s.charAt(left));
        }
        length--;
        left++;
      }
    }
    return result;
  }

  private boolean matches(HashMap<Character, Integer> tMap, HashMap<Character, Integer> sMap) {
    for (Character c : tMap.keySet()) {
      if (!sMap.containsKey(c) || (sMap.containsKey(c) && sMap.get(c) < tMap.get(c))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    //    String s = "ADOBECODEBANC", t = "ABC";

    //    String s = "a", t = "a";

    //    String s = "ab", t = "a";
    String s = "aa", t = "aa";

    MinWindowSubString minWindowSubString = new MinWindowSubString();
    System.out.println(minWindowSubString.minWindow(s, t));
  }
}
