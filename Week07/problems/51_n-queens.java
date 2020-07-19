class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;

        helper(res, new int[n], 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] queens, int row) {
        if (row == queens.length) {
            addSolution(res, queens);
            return;
        }
        // 每个位置都放一遍，看合法不合法
        for (int i = 0; i < queens.length; i++) {
            queens[row] = i;
            if (isValid(queens, row)) {
                helper(res, queens, row + 1);
            }
        }
    }

    private boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row]) { // 在同一列
                return false;
            } else if (Math.abs(queens[row] - queens[i]) == Math.abs(i-row)) { // 在同一对角线
                return false;
            }
        }
        return true;
    }

    private void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}