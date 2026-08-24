class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for(int i = 0; i < trips.length; i++){
            int person = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            diff[from] += person;
            diff[to] -= person;
        }
        int passenger = 0;
        for(int i = 0; i < diff.length; i++){
            passenger += diff[i];
            if(passenger > capacity) return false;
        }
        return true;
    }
}