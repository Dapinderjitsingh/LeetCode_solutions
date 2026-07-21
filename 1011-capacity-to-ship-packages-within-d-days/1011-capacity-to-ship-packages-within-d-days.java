class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        for( int w : weights ){
            if( w > low ){
                low = w;
            }
        }
        int high = 0;
        for( int w : weights ){
            high += w;
        }
        while(low < high){
            int mid = low + ( high - low ) / 2;
            int weight = 0;
            int day = 1;
            for(int i = 0; i < weights.length; i++){
                weight += weights[i];
                if(weight > mid){
                    day++;
                    weight = weights[i];
                }
            }
            if(days >= day) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}