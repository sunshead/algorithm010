class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] char_arr = str.toCharArray();
            Arrays.sort(char_arr);
            String key = new String(char_arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}