class Solution {

    // creates a map
    // iterate through the strings
    // validate if the character isn't in the map
    // if it's the map, validate if is the same character
    // otherwise return false
    // if isn't in the map, map the character in both ways a -> b and b -> a
    // if iterates through whole string and no character map broke the rules
    // return true

    // degg aadd
    // d -> a, a -> d
    // e -> a X
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> fowardMapT = new HashMap<>();
        Map<Character, Character> inwardMapT = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);

            if(!fowardMapT.containsKey(charS) && !inwardMapT.containsKey(charT)) {
                fowardMapT.put(charS, charT);
                inwardMapT.put(charT, charS);
            } else if(fowardMapT.get(charS) != charT || inwardMapT.get(charT) != charS) {
                return false;
            }
            continue;
        }

        return true;
    }
}