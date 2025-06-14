package P4DFS.Q5WordSearch;

public class WordSearch {

  boolean exist(char[][] board, String word) {
    if (word.length() == 0) {
      return false;
    }
    char start = word.charAt(0);
    StringBuilder temp = new StringBuilder();
    int[][] visited = new int[board.length][board[0].length];

    for (int row = 0; row < visited.length; row++) {
      for (int column = 0; column < visited[row].length; column++) {
        visited[row][column] = 0;
      }
    }

    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        if (board[row][column] == start) {
          boolean result = dfs(row, column, board, word, temp, visited);
          if (result) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs(int row, int column, char[][] board, String word, StringBuilder temp, int[][] visited) {
    visited[row][column] = 1;
    //R, L, U, D
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { 1, -1, 0, 0 };
    temp = temp.append(board[row][column]);
    if (word.contentEquals(temp)) {
      return true;
    }
    if (!word.substring(0, temp.length()).equals(temp.toString())) {
      visited[row][column] = 0;
      temp.deleteCharAt(temp.length() - 1);
      return false;
    }
    for (int direction = 0; direction < 4; direction++) {
      int newRow = row + dx[direction];
      int newColumn = column + dy[direction];
      if (isDirectionValid(newRow, newColumn, board, visited)) {
        boolean result = dfs(newRow, newColumn, board, word, temp, visited);
        if (result) {
          return true;
        }
      }
    }
    temp.deleteCharAt(temp.length() - 1);
    visited[row][column] = 0;
    return false;
  }

  private boolean isDirectionValid(int row, int column, char[][] board, int[][] visited) {
    return (row >= 0 && row < board.length && column >= 0 && column < board[0].length && visited[row][column] == 0);
  }

  public static void main(String[] args) {
    //    //@formatter:off
//    char[][] board = {
//        { 'A', 'B', 'C', 'E' },
//        { 'S', 'F', 'C', 'S' },
//        { 'A', 'D', 'E', 'E' }
//    };
//    //@formatter:on
    //    String word = "ABCCED";

    //    String word = "SEE";
    //    //@formatter:off
//    char[][] board = {
//            { 'A', 'B', 'C', 'E' },
//            { 'S', 'F', 'C', 'S' },
//            { 'A', 'D', 'E', 'E' }
//        };
    //@formatter:on

    String word = "acdb";
    char[][] board = { { 'a', 'b' }, { 'c', 'd' } };

    WordSearch wordSearch = new WordSearch();
    System.out.println(wordSearch.exist(board, word));
  }
}
