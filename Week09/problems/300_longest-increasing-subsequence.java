class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            int end = dp.size();
            while (start  < end) {
                int mid = start + (end - start) / 2;
                if (dp.get(mid) < nums[i]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (end >= dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(end, nums[i]);
            }
        }
        return dp.size();
    }
}