// floodfill
class Solution {
    private int[][] directions = {{-1,0}, {0,1},{1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    floodfill(grid, i, j);
                }
            }
        }
        return count;
    }

    private void floodfill(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] direction: directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == '1') {
                floodfill(grid, newX, newY);
            }
        }
    }
}