package P2SlidingWindow.Q1LengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Q1LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0;
    Set<Character> stringSet = new HashSet<>();
    int count = 0;
    int maxCount = 0;
    for (right = 0; right < s.length(); right++) {
      while (stringSet.contains(s.charAt(right))) {
        stringSet.remove(s.charAt(left));
        left++;
      }
      stringSet.add(s.charAt(right));
      count = right - left + 1;
      maxCount = Math.max(count, maxCount);
    }
    return maxCount;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    Q1LengthOfLongestSubstring substring = new Q1LengthOfLongestSubstring();
    System.out.println(substring.lengthOfLongestSubstring(s));
  }
}
