class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1);
    }

    private int decode(char[] chars, int index) {
        if (index < 0 || index == 0 && (chars[index] != '0')) {
            return 1;
        }

        int count = 0;
        char curr = chars[index];
        char prev = chars[index - 1];

        if (curr + '0' > 0) {
            count = decode(chars, index - 1);
        }

        if (prev == '1' || prev == '2' && (curr + '0' <= 6)) {
            count += decode(chars, index - 2);
        }

        return count;
    }
}