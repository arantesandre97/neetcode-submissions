// Is there a limit for quantity of numbers that this stack can store?
// How should functions behave when stack is empty?
// Those call will be made synchronous or asynchronously?

// edge cases:
// adding a element that is already present in the stack and it is the minimum one

// well I thought about use a dinamic array in the backbone to store the stack elements
// which will gives me O(1) insertion complexity time in average. But we'll need to traverse
// the array when we reach the array size, to put all elemements in a bigger on.
// we can do that also using a linked list, where we can guarantee always a O(1) in push operations
// and to peek and pop we just need to get the last node inserted

// Can I use a custom class to implement a linked list? or should use Java builtin classes?
// Because for maintaining the minimum element, we need to backtrack what are the minumum element
// at the moment that a element is inserted in the list

class MinStack {
    LinkedList<Integer> elements = new LinkedList<>();
    LinkedList<Integer> minimumElements = new LinkedList<>();
    public MinStack() {}

    public void push(int val) {
        elements.add(val);

        if (minimumElements.size() != 0) {
            int currentMinimum = minimumElements.peekLast();
            minimumElements.add(Math.min(currentMinimum, val));
        } else {
            minimumElements.add(val);
        }
    }

    public void pop() {
        elements.removeLast();
        minimumElements.removeLast();
    }

    public int top() {
        return elements.peekLast();
    }

    public int getMin() {
        return minimumElements.peekLast();
    }
}
