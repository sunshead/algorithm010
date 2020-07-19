class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] count = new int[256];
        for (char c: t.toCharArray()) {
            count[c]++;
        }
        int left = 0;
        int right = 0;
        int head = 0;
        int min = Integer.MAX_VALUE;
        int counter = t.length();
        while(right < s.length()) {
            if (count[s.charAt(right++)]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (right - left < min) {
                    min = right - left;
                    head = left;
                }
                if (++count[s.charAt(left++)] > 0) {
                    counter++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}