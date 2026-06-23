class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int i = s.length();
            char[] sChars = s.toCharArray();
            for (char c : sChars) {
                sChars[s.length() - i] = (char) (c + i);
                i--;
            }
            sb.append(s.length());
            sb.append("#");
            sb.append(String.valueOf(sChars));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        char[] sChars = str.toCharArray();

        while (i < sChars.length) {
            int j = i;
            while (sChars[j] != '#') j++;
            int wordLength = Integer.parseInt(str.substring(i, j));
            j++;

            char[] subString = new char[wordLength];
            for (int subIdx = 0; subIdx < wordLength; subIdx++) {
                subString[subIdx] = (char) (sChars[j + subIdx] - (wordLength - subIdx));
            }

            decodedStrings.add(String.valueOf(subString));
            i = j + wordLength;
        }

        return decodedStrings;
    }
}
