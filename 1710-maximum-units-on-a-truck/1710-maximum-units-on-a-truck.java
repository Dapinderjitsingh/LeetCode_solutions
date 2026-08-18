class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
         Arrays.sort(boxTypes , (a,b) -> b[1] - a[1]);
         int ans=0;
         for(int[] box : boxTypes){
            int min=Math.min(truckSize,box[0]);
            ans+=box[1]*min;
            truckSize-=min;
            if(truckSize==0) break;
         }
         return ans;
    }
}