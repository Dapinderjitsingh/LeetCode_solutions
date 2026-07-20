class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length ) return -1;
        int low = 1;
        int high = bloomDay[0];
        for(int day : bloomDay){
            high = Math.max(day,high);
        }
        while(low < high){
            int mid = low + (high - low) / 2;
            int flowers = 0;
            int bouquets = 0;
            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    flowers++;
                }
                else{
                    bouquets += flowers / k;
                    flowers = 0;
                }
            }
            bouquets += flowers / k;
            if( bouquets >= m ) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}