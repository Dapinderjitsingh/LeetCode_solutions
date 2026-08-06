class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    public String build(String str){
        Deque<Character> st = new ArrayDeque();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '#'){
                if(!st.isEmpty()) st.pop();
            }
            else st.push(ch);
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}