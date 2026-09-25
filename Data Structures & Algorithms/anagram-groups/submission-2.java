// Does a string alone must be considered as a anagram group?
// I'm thinking about using a hash map where the key will represent the first word inserted that
// doesn't pertence to a anagram group. What do you think?
// Every word I go through my string array I'll check if my map contains an anagram of that word
// otherwise this word will become a new group
// Is there a way to avoid a O(n^2) solution? Because I'll check for every string if there's an anagram
// present in my map. I'm thinking about order the string than check if it`s present. Can I use any Java API |
// to order it? Like Arrays.sort()
// this will give me O(k log k) in average for sort an char array, and O(k^2) in worst case, where k is my string length


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> subLists = new ArrayList<>();
        Map<String, Integer> groupIdxs = new HashMap<>();
        int i = 0;

        for(String s: strs) {
            char[] stringChars = s.toCharArray();
            Arrays.sort(stringChars);
            String sortedString = String.valueOf(stringChars);

            if(groupIdxs.containsKey(sortedString)) {
                int groupIdx = groupIdxs.get(sortedString);
                subLists.get(groupIdx).add(s);
            } else {
                groupIdxs.put(sortedString, i);
                subLists.add(new ArrayList<String>(List.of(s)));
                i++;
            }
        }

        return subLists;
    }
}