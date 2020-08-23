class Solution {
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c != ' ') {
                word.append(c);
            } else {
                res.append(word.reverse());
                res.append(' ');
                word.setLength(0);
            }
        }
        res.append(word.reverse());
        return res.toString();
    }
}