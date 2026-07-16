class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[26];
        int[] arrs = new int[26];
        int left = 0;
        int right = p.length();
        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            arr[ch - 'a']++;
        }
        if(s.length() < p.length()) return ans;
        for(int i = 0; i < p.length(); i++){
            char ch = s.charAt(i);
            arrs[ch - 'a']++;
        }
        if(Arrays.equals(arr,arrs)){
            ans.add(left);
        }
        while(right < s.length()){
            arrs[s.charAt(left) - 'a']--;
            left++;
            arrs[s.charAt(right) - 'a']++;
            right++;
            if(Arrays.equals(arr,arrs)){
                ans.add(left);
            }

        }
        return ans;
    }
}