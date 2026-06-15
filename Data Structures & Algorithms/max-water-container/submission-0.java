class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length-1;
        while(j > i){
            int volumn = Math.min(heights[j], heights[i]) * (j-i);
            if(max < volumn) max = volumn;
            if(heights[j] > heights[i]){
                i++;
            }else{
                j--;
            }
        }
        return max;
        
    }
}
