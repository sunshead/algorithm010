class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> unvisited = new HashSet<>(wordList);
        if (unvisited.contains(beginWord)) {
            unvisited.remove(beginWord);
        }
        Map<String, Integer> wordLevels = new HashMap<>();
        wordLevels.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            int currLevel = wordLevels.get(currWord);
            for (int i = 0; i < currWord.length(); i++) {
                char[] wordUnit = currWord.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordUnit[i] = j;
                    String newWord = new String(wordUnit);
                    if (unvisited.contains(newWord)) {
                        if (newWord.equals(endWord)) {
                            return currLevel + 1;
                        }
                        wordLevels.put(newWord, currLevel + 1);
                        queue.offer(newWord);
                        unvisited.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}