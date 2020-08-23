class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0, end = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, end);
                start = i + 1;
            } else {
                end = i;
            }
        }
        reverse(s, start, end);
    }

    void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}