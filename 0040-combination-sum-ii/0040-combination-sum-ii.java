class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, new ArrayList<>(), list, 0);
        return list;
    }

    private void solve(int[] candidates, int target, List<Integer> temp, List<List<Integer>> list, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }        
        if (target < 0 || start == candidates.length)
            return;
        
        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target)
                break;
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                solve(candidates, target - candidates[i], temp, list, i + 1);
                temp.remove(temp.size() - 1);
            }

        }
    }
}