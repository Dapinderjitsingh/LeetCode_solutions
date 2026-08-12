class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < asteroids.length; i++){
            boolean isAlive = true;
            while(isAlive && !st.isEmpty() && (st.peek() > 0 && asteroids[i] < 0)){
                if(-asteroids[i] > st.peek()){
                    st.pop();
                    continue;
                }
                if(-asteroids[i] == st.peek()){
                    st.pop();
                    isAlive = false;
                    break;
                }
                if(-asteroids[i] < st.peek()){
                    isAlive = false;
                    break;
                }
            }
            if(isAlive){
                st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];
        while(!st.isEmpty()){
            for(int i = st.size() - 1; i >= 0; i--){
                ans[i] = st.pop();
            }
        }
        return ans;
    }
}