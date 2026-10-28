class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        solve(s, new ArrayList<>(), list, 0);
        return list;
    }
    private void solve(String s, List<String> temp, List<String> list, int start){
        if(start == s.length()){
            if(temp.size() == 4){
            list.add(String.join(".", temp));
            }
            return;
        }
        if(temp.size() == 4)return;
        for(int i = start; i <= start + 2 && i < s.length(); i++){
            String part = s.substring(start, i + 1);
            if(part.length() > 1 && part.charAt(0) == '0'){
                continue;
            }
            int value = Integer.parseInt(part);
            if(value > 255){
                continue;
            }
            temp.add(part);
            solve(s, temp, list, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}