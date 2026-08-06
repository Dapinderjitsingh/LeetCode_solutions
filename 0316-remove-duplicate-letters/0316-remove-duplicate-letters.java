class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(visited[ch - 'a']) continue;
            while(!st.isEmpty() && st.peek() > ch && map.get(st.peek()) > i){
                char top = st.pop();
                visited[top - 'a'] = false;
            }
            st.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}