// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int[n];
//         Arrays.fill(dp, -1);
//         return solve(n - 1, dp, nums);
//     }
//     int solve(int index, int[] dp, int[] nums){
//         if(index == 0)return nums[0];
//         if(index < 0)return 0;
//         if(dp[index] != -1)return dp[index];
//         int take = nums[index] + solve(index - 2, dp, nums);
//         int not = 0 + solve(index - 1, dp, nums);
//         return dp[index] = Math.max(take, not);
        
//     }
// }

 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int take = nums[i];
            if(i > 1) take = nums[i] + dp[i - 2];
            int not = 0 + dp[i - 1];
            dp[i] = Math.max(take, not);
        }
        return dp[n - 1];
    }
}