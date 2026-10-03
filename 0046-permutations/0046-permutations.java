class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums, new ArrayList<>(), list, used);
        return list;
    }
    private void solve(int[] nums, List<Integer> temp, List<List<Integer>> list, boolean[] used){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] == true)continue;
            temp.add(nums[i]);
            used[i] = true;
            solve(nums, temp, list, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}