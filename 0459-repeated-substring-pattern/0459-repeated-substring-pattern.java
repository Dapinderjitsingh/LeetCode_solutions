class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 0;
        int j = 1;
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i + 1;
                i++;
                j++;
            }
            else if(i > 0){
                i = lps[i - 1];
            }
            else{
                lps[j] = 0;
                j++;
            }
        }
        int longest = lps[n - 1];
        int patternLength = n - longest;
        return longest > 0 && n % patternLength == 0;
    }
}