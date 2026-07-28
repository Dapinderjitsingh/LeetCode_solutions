class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            
            if ((mid == 0 || nums[mid] != nums[mid - 1]) &&
                (mid == n - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }

            if (mid % 2 == 0) {

                if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {

                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        return -1;
    }
}