class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList(list));
        }
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, pos + 1);
            list.remove(list.size() - 1);
        }
    }
}