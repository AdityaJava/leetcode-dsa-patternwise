package P7Backtracking.Q5NQueens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Position {
  int row;
  int column;

  public Position(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public String toString() {
    return "Position{" + "row=" + row + ", column=" + column + '}';
  }
}

class BlockedPositions {
  static Set<Integer> blockedRows = new HashSet<>();
  static Set<Integer> blockedColumns = new HashSet<>();
  static Set<Integer> blockedDiagonalsPositive = new HashSet<>();
  static Set<Integer> blockedDiagonalsNegative = new HashSet<>();

  public static void blockPosition(Position position) {
    blockedRows.add(position.row);
    blockedColumns.add(position.column);
    blockedDiagonalsNegative.add(position.row - position.column);
    blockedDiagonalsPositive.add(position.row + position.column);
  }

  public static void unBlockPosition(Position position) {
    blockedRows.remove(position.row);
    blockedColumns.remove(position.column);
    blockedDiagonalsNegative.remove(position.row - position.column);
    blockedDiagonalsPositive.remove(position.row + position.column);
  }

}

public class NQueens {
  public List<List<Position>> solveNQueens(int n) {
    List<List<Position>> answers = new ArrayList<>();
    List<Position> answer = new ArrayList<>();
    for (int column = 0; column < n; column++) {
      dfs(new Position(0, column), n, answers, answer);
    }
    return answers;
  }

  private boolean dfs(Position position, int n, List<List<Position>> answers, List<Position> answer) {
    if (answer.size() == n) {
      answers.add(new ArrayList<>(answer));
      return true;
    }
    int row = position.row;
    for (int column = position.column; column < n; column++) {
      Position newPosition = new Position(row, column);
      if (isPositionValid(newPosition)) {
        answer.add(newPosition);
        BlockedPositions.blockPosition(newPosition);
        boolean result = dfs(new Position(row + 1, 0), n, answers, answer);
        BlockedPositions.unBlockPosition(newPosition);
        answer.removeLast();
        if (!result) {
          return false;
        }
      }
    }
    return false;
  }

  private boolean isPositionValid(Position position) {
    int negativeDiagonal = position.row - position.column;
    int positiveDiagonal = position.row + position.column;
    return !BlockedPositions.blockedRows.contains(position.row)
        && !BlockedPositions.blockedColumns.contains(position.column)
        && !BlockedPositions.blockedDiagonalsPositive.contains(positiveDiagonal)
        && !BlockedPositions.blockedDiagonalsNegative.contains(negativeDiagonal);
  }

  public static void main(String[] args) {
    NQueens nQueens = new NQueens();
    nQueens.solveNQueens(4).forEach(System.out::println);
  }
}
