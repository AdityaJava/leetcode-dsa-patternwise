package P5BFS.Q3WordLadder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

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
    List<String> wordList = Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain");

    WordLadder wordLadder = new WordLadder();
    System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
  }
}
