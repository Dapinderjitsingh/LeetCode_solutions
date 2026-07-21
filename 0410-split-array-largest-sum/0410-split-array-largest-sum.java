class Solution {
    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        for( int ele : nums ){
            if(ele > low) low = ele;
        }
        int high = 0;
        for( int ele : nums ){
            high += ele;
        }
        while( low < high ){
            int mid = low + ( high - low ) / 2;
            int subarray = 1;
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                if(sum > mid){
                subarray++;
                sum = nums[i];
                }
            }
            if( subarray <= k) high = mid;
            else low = mid + 1;

        }
        return low;
    }

}