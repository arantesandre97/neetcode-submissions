class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sublists = new ArrayList<>();
        
        if(strs.length == 0)
            return sublists;

        Map<String, Integer> groups = HashMap.newHashMap(strs.length);

        int i = 0;
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = String.valueOf(chars);
            Integer groupIdx = groups.get(sortedS);

            if(groupIdx == null) {
                groups.put(sortedS, i);
                sublists.add(i, new ArrayList<>(List.of(s)));
                i++;
            } else {
                sublists.get(groupIdx).add(s);
            }
        }

        return sublists;
    }
}
