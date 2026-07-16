class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freqp = new int[26];
        int[] freqs = new int[26];
        int left = 0;
        int right = p.length();
        for( int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            freqp[ch - 'a']++;
        }
        if(p.length() > s.length()) return ans;
        for( int i =0; i < p.length(); i++ ){
            char ch = s.charAt(i);
            freqs[ch - 'a']++;
        }
        if(Arrays.equals(freqp,freqs)){
            ans.add(left);
        }
        while(right < s.length()){
            freqs[s.charAt(left) - 'a' ]--;
            left++;
            freqs[s.charAt(right) - 'a' ]++;
            right++;
            if(Arrays.equals(freqp,freqs)){
                ans.add(left);
            }
        }
        return ans;
    }
}