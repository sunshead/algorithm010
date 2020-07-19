class Solution {
    int[][] rows = new int[9][10];
    int[][] columns = new int[9][10];
    int[][] boxes = new int[9][10];

    char[][] board;

    boolean solved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    int num = Character.getNumericValue(curr);
                    putNum(num, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    // put a number in (row,col) cell
    public void putNum(int num, int row, int col) {
        // cell index
        int index = (row / 3) * 3 + col / 3;

        rows[row][num]++;
        columns[col][num]++;
        boxes[index][num]++;
        board[row][col] = (char)(num + '0');
    }

    // remove a number that didn't lead to a solution
    public void removeNum(int num, int row, int col) {
        int index = (row / 3) * 3 + col / 3;

        rows[row][num]--;
        columns[col][num]--;
        boxes[index][num]--;
        board[row][col] = '.';
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (canPut(i, row, col)) {
                    putNum(i, row, col);
                    putNextNums(row, col);
                    if (!solved) {
                        removeNum(i, row, col);
                    }
                }
            }
        } else {
            putNextNums(row, col);
        }
    }

    public boolean canPut(int num, int row, int col) {
        int index = (row / 3) * 3 + col / 3;

        return rows[row][num] + columns[col][num] + boxes[index][num] == 0;
    }

    public void putNextNums(int row, int col) {
        if (col == 8 && row == 8) {
            solved = true;
        } else {
            // go to the next row if we're at the end of the row
            if (col == 8) {
                backtrack(row+1, 0);
            } else {
                backtrack(row, col+1);
            }
        }
    }
}