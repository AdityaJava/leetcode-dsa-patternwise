package P5BFS.Q5RottenOranges;

import java.util.LinkedList;
import java.util.Queue;

class OrangePosition {
  int row;
  int column;

  public OrangePosition(int row, int column) {
    this.row = row;
    this.column = column;
  }
}

public class RottenOranges {
  public int orangesRotting(int[][] grid) {
    return bfs(grid);
  }

  private int bfs(int[][] grid) {
    Queue<OrangePosition> queue = initializeQueue(grid);
    //r,l,u,d
    int[] directionX = { 0, 0, -1, 1 };
    int[] directionY = { 1, -1, 0, 0 };
    int minutes = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        OrangePosition temp = queue.poll();
        for (int direction = 0; direction < 4; direction++) {
          int newRow = temp.row + directionX[direction];
          int newColumn = temp.column + directionY[direction];
          OrangePosition newOrangePosition = new OrangePosition(newRow, newColumn);
          if (isDirectionValid(grid, newOrangePosition)) {
            grid[newRow][newColumn] = 2;
            queue.add(newOrangePosition);
          }
        }
      }
      minutes++;
    }
    return areAllOrangesRotten(grid) ? minutes == -1 ? 0 : minutes : -1;
  }

  private boolean areAllOrangesRotten(int[][] grid) {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == 1) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isDirectionValid(int[][] grid, OrangePosition newOrangePosition) {
    int newRow = newOrangePosition.row, newColumn = newOrangePosition.column;
    return newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length && grid[newRow][newColumn] == 1;
  }

  private Queue<OrangePosition> initializeQueue(int[][] grid) {
    Queue<OrangePosition> queue = new LinkedList<>();
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == 2) {
          queue.add(new OrangePosition(row, column));
        }
      }
    }
    return queue;
  }

  public static void main(String[] args) {
    //    int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    int[][] grid = { { 0 } };
    RottenOranges rottenOranges = new RottenOranges();
    System.out.println(rottenOranges.orangesRotting(grid));
  }
}
