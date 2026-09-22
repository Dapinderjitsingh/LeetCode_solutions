class Solution {
    class pair{
        char ch;
        int fq;
        pair(char ch, int fq){
            this.ch = ch;
            this.fq = fq;
        }
    }
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> b.fq - a.fq);
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < freq.length; i++){
            char ch = (char)('a' + i);
            if(freq[i]  > 0){
                pq.offer(new pair(ch, freq[i]));
            }
        }
        pair prev = null;
        while(!pq.isEmpty()){
            pair current = pq.poll();
            if(prev != null && prev.fq > 0){
                pq.offer(prev);
            }
            ans.append(current.ch );
            current.fq--;
            prev = current;
        }
        if(ans.length() != s.length()) return "";
        return ans.toString();
    }
}