class Solution {
    public boolean isPalindrome(String s) {
        char[] stringChars = s.toCharArray();
        int rightPointer = 0;
        int leftPointer = stringChars.length - 1;

        while(rightPointer < leftPointer){
            while(rightPointer < leftPointer && !isAlphaNumeric(stringChars[rightPointer])) {
                rightPointer++;
            }

            while(leftPointer > rightPointer && !isAlphaNumeric(stringChars[leftPointer])) {
                leftPointer--;
            }

            if(Character.toLowerCase(stringChars[rightPointer]) != Character.toLowerCase(stringChars[leftPointer]))
                return false;

            rightPointer++;
            leftPointer--;
        }

        return true;
    }

    public boolean isAlphaNumeric(char c) {
        if((c >= 'a' && c <= 'z')
            ||(c >= 'A' && c <= 'Z')
            ||(c >= '0' && c <= '9'))
            return true;

        return false;
    }
}
