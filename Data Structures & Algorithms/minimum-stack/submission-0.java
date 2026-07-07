class MinStack {
    // push each element along with the min seen so far
    
    class Pair {
        int val;
        int min;

        public Pair(int val, int min)
        {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int new_min = stack.isEmpty() ? val : Math.min(stack.peek().min, val);
        stack.push(new Pair(val, new_min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        Pair top = stack.peek();
        return top.val;
    }
    
    public int getMin() {
        Pair peek = stack.peek();
        return peek.min;
    }
}
