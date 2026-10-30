// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//      for(int i=1;i<nums.length;i++){
//         for(int j=i;j<nums.length;j++){
//             if(target==nums[j]+nums[j-i])
//             return new int[]{j-i,j};
//         }
//      }   
//      return new int[]{};
//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        for(int i = 0; i < nums.length; i++) {
            
            for(int j = i + 1; j < nums.length; j++) {
                
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                
            }
            
        }
        
        return new int[]{};
    }
}

//will do it later by hashmapping optimal approach.

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i = 0; i < nums.length; i++){
//         int curr = nums[i];
//         int diff = target - nums[i];
//         if(map.containsKey(diff)){
//             return new int[]{map.get(diff),i};
//         } 
//         else map.put(curr,i);
//         }
//         return new int[]{};
//     }
// }