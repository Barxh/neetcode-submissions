class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] n1 = new int[nums.length];
        int[] n2 = new int[nums.length];

        n1[0] = 1;
        n2[nums.length - 1] = 1;

        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            n1[i] = nums[i - 1] * n1[i - 1];
            n2[j] = nums[j + 1] * n2[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            n1[i] *= n2[i];
        }
        return n1;
    }
}
