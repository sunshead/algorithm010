class Solution {
    char[] str;
    public String reverseStr(String s, int k) {
        if (s == null) return s;
        str = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            reverse(i, Math.min(i + k - 1, s.length() - 1));
            i += 2 * k;
        }
        return new String(str);
    }

    void reverse(int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}