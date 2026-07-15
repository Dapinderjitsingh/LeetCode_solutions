// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int num : nums){
//             map.put(num,map.getOrDefault(num,0)+1);
//         }
//         PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
//         for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//             pq.add(entry);
//         }
//         int[] ans = new int[k];
//         for(int i = 0; i < k; i++){
//             ans[i] = pq.poll().getKey();
//         }
//         return ans;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer>[] bucket= new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            int n = map.get(key);
            if(bucket[n]==null){
                bucket[n]= new ArrayList<>();

            }
            bucket[n].add(key);
        }
        int[] ans = new int[k];
        int index=0;
        for(int i = bucket.length-1; i >= 1; i--){
            if(bucket[i]!=null){
                for(int n : bucket[i]){
                    ans[index++]=n;
                    if(index==k) return ans;
                }
            }
        }
        return ans;
    }
}