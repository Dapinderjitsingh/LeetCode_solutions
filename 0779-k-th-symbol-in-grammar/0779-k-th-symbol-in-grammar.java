class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int half = (int)Math.pow(2,n-2);
        if(k <= half){
            return kthGrammar(n - 1, k);
        }
        else {
            int newk = k - half;
            int result = kthGrammar(n - 1, newk);
            return result == 0 ? 1 : 0;
        }
    }
}