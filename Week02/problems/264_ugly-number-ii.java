class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[index2] * 2, Math.min(uglyNums[index3] * 3, uglyNums[index5] * 5));
            if (uglyNums[i] == uglyNums[index2] * 2) {
                index2++;
            }
            if (uglyNums[i] == uglyNums[index3] * 3) {
                index3++;
            }
            if (uglyNums[i] == uglyNums[index5] * 5) {
                index5++;
            }
        }
        return uglyNums[n-1];
    }
}