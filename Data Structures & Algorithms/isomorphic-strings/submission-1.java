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
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);

            if((mapST.containsKey(charS) && !mapST.get(charS).equals(charT)) 
                || (mapTS.containsKey(charT) && !mapTS.get(charT).equals(charS))) {
                return false;
            } 
                
            mapST.put(charS, charT);
            mapTS.put(charT, charS);
        }

        return true;
    }
}