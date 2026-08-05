class MinStack {
    Stack<Integer> stMain;
    Stack<Integer> stMin;

    public MinStack() {
        stMain = new Stack<>();
        stMin = new Stack<>();
    }
    
    public void push(int value) {
        stMain.push(value);
        if(stMin.isEmpty() || value <= stMin.peek()){
            stMin.push(value);
        }
    }
    
    public void pop() {
        int x = stMain.pop();
        if(x == stMin.peek()) stMin.pop();
    }
    
    public int top() {
        return stMain.peek();
    }
    
    public int getMin() {
        return stMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */