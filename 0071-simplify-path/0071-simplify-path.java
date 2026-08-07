class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (part.equals(".") || part.equals("")) {
                //ignore
            }
            else if (part.equals("..")){
                if(!st.isEmpty()){
                     st.pop();
                }
            }
            else
                st.push(part);
        }
        StringBuilder ans = new StringBuilder();
        Deque<String> st2 = new ArrayDeque<>();
        while (!st.isEmpty()) {
            st2.push(st.pop());
        }
        while (!st2.isEmpty()) {
            ans.append("/");
            ans.append(st2.pop());
        }
        if (ans.length() == 0) return "/";
        return ans.toString();
    }
}