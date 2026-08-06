class Solution {
    public String makeGood(String s) {
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        if(! st.isEmpty() && Character.toLowerCase(st.peek()) == Character.toLowerCase(ch) && st.peek() != ch) st.pop();
        else st.push(ch);
       }
       while(!st.isEmpty()){
        ans.append(st.pop());
        }
       return ans.reverse().toString();
    }
}