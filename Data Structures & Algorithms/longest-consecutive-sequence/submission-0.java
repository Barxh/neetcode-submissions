class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int max = 0;
        Set<Integer> checked = new HashSet<>();
        for(int n : set){
            if(checked.contains(n)) continue;
            int counter = 1;
            for(int i = 1; set.contains(n - i); i++){
                counter++;
                checked.add(n - 1);
            }
            for(int i = 1; set.contains(n + i); i++){
                counter++;
                checked.add(n + 1);
            }
            if(counter > max){
                max = counter;
            }
        }
        return max;
    }
}
