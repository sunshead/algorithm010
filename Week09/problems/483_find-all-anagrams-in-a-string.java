class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList();
        if (sLen < pLen) {
            return res;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (char c: p.toCharArray()) {
            pCount[c - 'a']++;
        }
        // sliding window on str s
        for (int i = 0; i < sLen; i++) {
            // add one letter on the right side of the window
            sCount[s.charAt(i) - 'a']++;
            // remove one letter from the left side of the window
            if (i >= pLen) {
                sCount[s.charAt(i - pLen) - 'a']--;
            }
            // compare two arrays
            if (Arrays.equals(pCount, sCount)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }
}