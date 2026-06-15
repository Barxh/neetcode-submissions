class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int totalProduct = 1;
        int zeroPosition = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(zeroPosition == -1){
                    zeroPosition = i; 
                }else{
                    zeroPosition = -2;
                    break;
                }
            }else{
                totalProduct *= nums[i];
            }
            
        }
        if(zeroPosition == -1){
            for(int i = 0; i < nums.length; i++){
            result[i] = totalProduct / nums[i];
            }
        }else if( zeroPosition > -1){
            result[zeroPosition] = totalProduct;
        }
        
        return result;
    }
}  
