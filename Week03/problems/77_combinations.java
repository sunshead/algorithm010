class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || n <= 0 || k <= 0) {
            return res;
        }
        helper(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    private void helper(int n, int k, List<List<Integer>> res, ArrayList<Integer> list, int pos) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            helper(n, k, res, list, i+1);
            list.remove(list.size() - 1);
        }
    }
}