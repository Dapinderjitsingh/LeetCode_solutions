class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        solve(s, new ArrayList<>(), list, 0);
        return list;
    }
    private void solve(String s, List<String> temp, List<List<String>> list, int start){
        if(start == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String part = s.substring(start, i + 1);
            if(ispalindrome(part)){
                temp.add(part);
                solve(s, temp, list, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }
    private boolean ispalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}