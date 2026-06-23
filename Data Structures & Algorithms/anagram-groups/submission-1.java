class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sublists = new ArrayList<>();
        
        if(strs.length == 0)
            return sublists;

        Map<String, List<String>> groups = HashMap.newHashMap(strs.length);

        for(String s : strs) {
            // counting letter from a to z lowercase, this is the maximum size of our array
            // the worst case would be one appearance of each letter
            char[] chars = new char[26];

            for(char c : s.toCharArray()) {
                chars[c - 'a'] += 1;
            }

            String listKey = Arrays.toString(chars);
            List<String> list = groups.get(listKey); 
            
            if(list != null) {
                list.add(s);
            } else {
                groups.put(listKey, new ArrayList<>(List.of(s)));
            }
        }

        sublists.addAll(groups.values());
        return sublists;
    }
}