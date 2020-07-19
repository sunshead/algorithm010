class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, (a, b) -> b - a);
        for (int count: map) {
            if (count > 0) {
                pq.offer(count);
            }
        }
        int time = 0;
        while(!pq.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        temp.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                time++;
                i++;
                if (pq.isEmpty() && temp.size() == 0) break;
            }
            for (int t: temp) {
                pq.offer(t);
            }
        }
        return time;
    }
}