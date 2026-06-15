class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) return -1;
        int i = nums.length / 2;
        int downLimit = -1;
        int upperLimit = nums.length;
        while(i != downLimit){
            if(nums[i] == target){
                return i;
            }else if(nums[i] > target){
                upperLimit = i;
                i = downLimit + (i - downLimit)/2;
                
            }else{
                downLimit = i;
                i = downLimit + (upperLimit - i)/2;
            }
        }
        return -1;
    }
}
