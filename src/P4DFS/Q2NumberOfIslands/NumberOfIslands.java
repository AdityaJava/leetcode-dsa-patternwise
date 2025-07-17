package P4DFS.Q2NumberOfIslands;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    int[][] visited = new int[grid.length][grid[0].length];
    int count = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == '1' && visited[row][column] == 0) {
          dfs(row, column, visited, grid);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(int row, int colum, int[][] visited, char[][] grid) {
    visited[row][colum] = 1;
    //right, left, up, down
    int[] directionX = { 0, 0, -1, 1 };
    int[] directionY = { 1, -1, 0, 0 };
    visited[row][colum] = 1;
    for (int direction = 0; direction < 4; direction++) {
      int currRow = row - directionX[direction];
      int currCol = colum - directionY[direction];
      if (isPointValid(currRow, currCol, visited, grid)) {
        dfs(currRow, currCol, visited, grid);
      }
    }
  }

  private boolean isPointValid(int currRow, int currColumn, int[][] visited, char[][] grid) {
    return currRow >= 0 && currRow < visited.length && currColumn >= 0 && currColumn < visited[0].length
      && visited[currRow][currColumn] == 0 && grid[currRow][currColumn] == '1';
  }

  public static void main(String[] args) {
    //char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
    char[][] grid = {
      { '1', '1', '0', '0', '0' },
      { '1', '1', '0', '0', '0' },
      { '0', '0', '1', '0', '0' },
      { '0', '0', '0', '1', '1' }
    };

    NumberOfIslands numberOfIslands = new NumberOfIslands();
    System.out.println(numberOfIslands.numIslands(grid));
  }
}
