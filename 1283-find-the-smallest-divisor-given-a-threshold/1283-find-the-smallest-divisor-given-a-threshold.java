class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        for(int num : nums){
            high = Math.max(num, high);
        }
        while(low < high){
            int mid = low + ( high - low ) / 2;
            int totalthreshold = 0;
            for(int i = 0; i < nums.length; i++){
                totalthreshold += (nums[i] + mid - 1) / mid;

            }
            if(totalthreshold <= threshold) high = mid;
            else low = mid + 1;

        }
        return low;
    }
}