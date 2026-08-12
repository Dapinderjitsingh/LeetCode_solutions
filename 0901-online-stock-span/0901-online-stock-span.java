class StockSpanner {
    Deque<Integer> rate;
    Deque<Integer> span;
    public StockSpanner() {
        rate = new ArrayDeque<>();
        span = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int currentspan = 1;
        while(!rate.isEmpty() && rate.peek() <= price){
            currentspan += span.peek();
            rate.pop();
            span.pop();
        }
        rate.push(price);
        span.push(currentspan);
        return currentspan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */