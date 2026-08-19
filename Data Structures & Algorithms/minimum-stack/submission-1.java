class MinStack {
    private int[] stack;
    private int[] minimumStack;
    private int currPosition;

    public MinStack() {
        this.stack = new int[30000];
        this.minimumStack = new int[30000];
        this.currPosition = 0;
    }
    
    public void push(int val) {
        this.stack[currPosition] = val;

        if(currPosition > 0)
            this.minimumStack[currPosition] = Math.min(val, this.minimumStack[currPosition - 1]);
        else
             this.minimumStack[currPosition] = val;

        currPosition++;
    }
    
    public void pop() {
        this.stack[currPosition] = 0;
        this.minimumStack[currPosition] = 0;
        currPosition--;
    }
    
    public int top() {
        return this.stack[currPosition - 1];
    }
    
    public int getMin() {   
        return this.minimumStack[currPosition - 1];
    }
}
