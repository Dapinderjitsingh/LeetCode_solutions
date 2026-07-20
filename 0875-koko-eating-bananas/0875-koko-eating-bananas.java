class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for(int i = 0; i < piles.length; i++){
            if( piles[i] > high ) high = piles[i];
        }
        while(low < high){
            int mid = low + ( high - low ) / 2;
            int totalhours = 0;
            for( int i = 0; i < piles.length; i++ ){
                int hours = piles[i] / mid;
                if(piles[i] % mid != 0){
                    hours++;
                }
                totalhours = totalhours + hours;
            }
            if(totalhours <= h) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}