class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int consent = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        while(i < g.length && j < s.length){
            if( s[j] >= g[i]){
                consent++;
                i++;
            }
            j++;
        }
        return consent;
    }
}