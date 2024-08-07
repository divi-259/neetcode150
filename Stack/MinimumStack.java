class MinStack {
    Stack<Integer> min;
    Stack<Integer> stack;
    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // pushing the min element corresponding to this present elment
        val = Math.min(val, min.isEmpty() ? val : min.peek());
        min.push(val);
        
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
