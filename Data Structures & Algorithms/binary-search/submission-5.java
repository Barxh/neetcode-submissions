class Solution {
    public int search(int[] nums, int target) {
        if ((nums.length == 1 && nums[0] != target) || nums.length == 0) return -1;
        int i = nums.length / 2;
        if (nums[i] == target) {
            return i;
        } else if (nums[i] > target && nums.length > 1) {
            int result = search(Arrays.copyOfRange(nums, 0, i), target);
            return result == -1 ? -1 : result; 
        } else if (nums[i] < target && nums.length > 1) {
            int result = search(Arrays.copyOfRange(nums, i, nums.length), target);
            return result == -1 ? -1 : i + result ;
        }

        return -1;
    }
}
