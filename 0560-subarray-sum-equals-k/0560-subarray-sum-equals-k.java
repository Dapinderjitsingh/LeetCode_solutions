class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // we have seen the prefix sum zero before the loop starts.
        int sum = 0;
        int count = 0;
        for( int num : nums){
            sum = sum + num;
            int need = sum - k;
            if(map.containsKey(need)){
                count += map.get(need);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }
}


// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             int sum=0;
//             for(int j=i;j<nums.length;j++){
//                 sum +=nums[j];
//                 if(sum==k) count++;
//             }
//         }
//         return count;
//     }
// }

