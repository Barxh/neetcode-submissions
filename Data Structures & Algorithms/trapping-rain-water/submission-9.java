class Solution {
    public int trap(int[] height) {
        if(height.length < 2) return 0;
        int max = 0;
        int i = 0;
        int upperLimit = height.length - 1;
        while(height[i] < height[i+1]){
            i++;
            if( i + 2 >= height.length) return 0;
        }
        while(height[upperLimit] < height[upperLimit-1]){
            if( upperLimit - 1 == i) return 0;
            upperLimit--;
        }
        int j = i + 1;
        while(j <= upperLimit){
            if(height[i] > height[j]){
                j++;
                System.out.println(j);
                continue;
            }
            int min = Math.min(height[i], height[j]);
            i++;
            while(i < j){
                max += min-height[i]; 
                System.out.println(height[i]);
                i++;
            }
            j++;
        }
        j--;
        while(height[i] > height[j]){
            i++;
        }
        
        while(i < j){
                max += height[j]-height[i]; 
                i++;
            }
        return max;

    }
}
