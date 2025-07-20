package P5BFS.Q3WordLadder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
//https://leetcode.com/problems/word-ladder/description/

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int[] count = new int[1];
    count[0] = 1;
    if (!wordList.contains(endWord)) {
      return 0;
    }
    Set<String> myWordSet = wordList.stream().collect(Collectors.toSet());
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    boolean result = false;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        result = tryEveryAlphabet(queue, myWordSet, endWord, count);
        if (result) {
          return count[0] + 1;
        }
      }
      count[0]++;
    }
    return 0;
  }

  private boolean tryEveryAlphabet(Queue<String> queue, Set<String> myWordSet, String endWord, int[] count) {
    String string = queue.poll();
    StringBuilder sb = new StringBuilder(string);
    for (int i = 0; i < sb.length(); i++) {
      sb = new StringBuilder(string);
      for (char c = 'a'; c <= 'z'; c++) {
        sb.setCharAt(i, c);
        if (endWord.contentEquals(sb)) {
          return true;
        }
        if (!string.contentEquals(sb) && myWordSet.contains(sb.toString())) {
          queue.add(sb.toString());
          myWordSet.remove(sb.toString());
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //    String beginWord = "hit", endWord = "cog";
    //    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    //        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");

    //    String beginWord = "hot", endWord = "dog";
    //    List<String> wordList = Arrays.asList("hot", "dog");

    //    String beginWord = "a", endWord = "c";
    //    List<String> wordList = Arrays.asList("a", "b", "c");

    String beginWord = "ymain", endWord = "oecij";
    List<String> wordList = Arrays.asList(
      "ymann",
      "yycrj",
      "oecij",
      "ymcnj",
      "yzcrj",
      "yycij",
      "xecij",
      "yecij",
      "ymanj",
      "yzcnj",
      "ymain"
    );

    WordLadder wordLadder = new WordLadder();
    System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
  }
}
