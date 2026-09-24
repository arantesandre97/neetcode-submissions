// if my string is empty I may return 0, right? as we have only ASCII printable character there's no chance of a blank string
// so I need to start from i and go through i + n until I find a duplicate character, right?
// and I find a duplicate character I need to remove characters from my string until there's no duplicated ones
// which means that my substring must be contiguous, did I understod it correctly?
// I'll need to control the characters in my current string, for that I need a data structure that I can check if
// I already have this character. As I'm not able to have duplicates, a Set sounds great for me. what you tell me?
// So I start from position 0 and keeping growing my substring until I find a duplicate character. When it happens
// may I check if my last substring length is smaller then my current one, if it is I turn my current length as the longest
// I think we're in the right track here, what u think?

/*
set of characters
declare l as 0
longestSubString as 0
loop r from 0 to length - 1
while(charSet contains string[r])
    charSet remove string[r]
    l++
if(longestSubString < (r - l + 1))
    longestSubString = r - l + 1
chartSet put string[r]
 
charSet = x,y,z 
longest = 3
    r
  l
"zxyz"

 

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int longestSubstring = 0;

        for(int r = 0; r < s.length(); r++) {
            while(charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }

            if(longestSubstring < (r - l + 1))
                longestSubstring = r - l + 1;

            charSet.add(s.charAt(r));
        }

        return longestSubstring;
    }
}
