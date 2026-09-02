class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String pat = s + "#" + rev;
        int n = pat.length();
        int[] lps = new int[n];
        int i = 0, j = 1;
        while(j < n){
            if(pat.charAt(i) == pat.charAt(j)){
                lps[j++] = ++i;
            }
            else if(i > 0){
                i = lps[i - 1];
            }else{
                j++;
            }
        }
        String rem = s.substring(lps[n - 1]);
        String add = new StringBuilder(rem).reverse().toString();
        return add + s;
    }
}