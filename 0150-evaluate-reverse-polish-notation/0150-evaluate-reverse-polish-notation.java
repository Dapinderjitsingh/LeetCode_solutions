class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String ch : tokens){
            if(ch.equals("+")){
                int b = st.pop();
                int a = st.pop();
                st.push(a+b);
            }
            else if(ch.equals("-")){
                int b = st.pop();
                int a = st.pop(); 
                st.push(a-b);
            }
            else if(ch.equals("*")){
                int b = st.pop();
                int a = st.pop();
                st.push(a*b);
            }
            else if(ch.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);                
            }
            else st.push(Integer.parseInt(ch));
        }
        return st.pop();
    }
}