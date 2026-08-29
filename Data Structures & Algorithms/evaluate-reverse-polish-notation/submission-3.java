class Solution {
    // RPN is a notation where the operator come at the end
    // Will gonna have integer and 4 types of symbols representing: add, subtraction, times, division.
    // We need to differ symbols from numbers
    // What are the best way to itarates through the string array? Which way a RPN usually is read?
    // RPN valid expression gonna pick 2 elements each time
    // A RPN is read from the left side to the right side, when u see a number (operand) you gonna stack it until a symbol (operator) is reached
    // Then you execute the arithmetic operation picking the last two elements of the stack
    // How should I handle division by zero?

    // Create a stack to hold the current operands and the result of operations
    // Iterates from my string array
    // Is it a operator? If isn't, convert the string element to a Integer and push it on my stack, if is I gonna pop the two last elements 
    // from my stack executing the operator arithmetic operation
    // If if a division or subtraction the order is very important, the first element is the last popped one
    // the division must be rounded to zero (parse it to int gonna fill this condition)
    // When iterates throw the whole string array, return the stack head
    public int evalRPN(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();

        for(String s : tokens) {
            switch(s) {
                case "+":
                    operands.push(operands.pop() + operands.pop());
                    break;
                case "-":
                    int a = operands.pop();
                    int b = operands.pop();
                    operands.push(b - a);
                    break;
                case "/":
                    int c = operands.pop();
                    int d = operands.pop();
                    operands.push(d / c);
                    break;
                case "*":
                    operands.push(operands.pop() * operands.pop());
                    break;
                default:
                    operands.push(Integer.valueOf(s));
                    break;
            }
        }

        return operands.peek();
    }
}
