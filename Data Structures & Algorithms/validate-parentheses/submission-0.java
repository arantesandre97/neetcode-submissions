class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(Character c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(stack.peek() == null
                || c == ')' && stack.peek() != '('
                || c == '}' && stack.peek() != '{'
                || c == ']' && stack.peek() != '[') {
                return false;
            }
            else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
