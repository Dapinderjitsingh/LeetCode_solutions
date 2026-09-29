class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        back(nums, new ArrayList<>(), list, 0);
        return list;
    }

    private void back(int[] nums, List<Integer> temp, List<List<Integer>> list, int start) {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            back(nums, temp, list, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}