class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (j > i) {
            if ((numbers[i] + numbers[j]) == target) {
                return new int[] {i+1,j+1};
            }
            if (j - i == 1)
                break;
            if (Math.abs((numbers[i + 1] + numbers[j] - target))
                < Math.abs((numbers[i] + numbers[j-1] - target))) {
                    i++;
            }else j--;
        }
        return new int[2];
    }
}
