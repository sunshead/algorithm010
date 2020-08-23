class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValidPalin(s, left + 1, right) || isValidPalin(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isValidPalin(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}