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

class Converter {

  public static List<List<String>> convertToAnswer(List<List<Position>> answers, int n) {
    List<List<String>> stringAnswers = new ArrayList<>();
    for (List<Position> answer : answers) {
      stringAnswers.add(convertToSingleMatrix(answer, n));
    }
    return stringAnswers;
  }

  public static List<String> convertToSingleMatrix(List<Position> answer, int n) {
    List<String> matrixes = new ArrayList<>();
    for (int row = 0; row < n; row++) {
      Position tempPosition = answer.get(row);
      StringBuilder matrix = new StringBuilder();
      for (int col = 0; col < n; col++) {
        if (tempPosition.row == row && tempPosition.column == col) {
          matrix.append("Q");
        }
        else {
          matrix.append(".");
        }
      }
      matrixes.add(matrix.toString());
    }
    return matrixes;
  }
}

public class NQueens {
  public List<List<String>> solveNQueens(int n) {
    List<List<Position>> answers = new ArrayList<>();
    List<Position> answer = new ArrayList<>();
    for (int column = 0; column < n; column++) {
      dfs(new Position(0, column), n, answers, answer);
    }
    return Converter.convertToAnswer(answers, n);
  }

  private void dfs(Position position, int n, List<List<Position>> answers, List<Position> answer) {
    if (answer.size() == n) {
      answers.add(new ArrayList<>(answer));
      return;
    }
    int row = position.row;
    for (int column = position.column; column < n; column++) {
      Position newPosition = new Position(row, column);
      if (isPositionValid(newPosition)) {
        answer.add(newPosition);
        BlockedPositions.blockPosition(newPosition);
        dfs(new Position(row + 1, 0), n, answers, answer);
        BlockedPositions.unBlockPosition(newPosition);
        answer.removeLast();
      }
    }
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
    int n = 4;
    NQueens nQueens = new NQueens();
    nQueens.solveNQueens(n).forEach(System.out::println);
  }
}