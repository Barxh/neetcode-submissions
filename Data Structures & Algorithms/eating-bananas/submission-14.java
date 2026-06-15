class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        long pilesTotal = 0;
        for(int pile : piles){
            pilesTotal += pile;
            if(max<pile){
                max = pile;
            }
        }
        System.out.println(pilesTotal + h);
        int downLimit = (int) ((pilesTotal + h - 1) / h); // 3
        int upperLimit = max; // 
        int min = max;
        while(downLimit <= upperLimit){
            
            int i = downLimit + (upperLimit - downLimit) / 2; // 
            int time = 0;
            for(int pile : piles){
                time += (pile + i - 1) / i;
            }
            if(time > h){
                downLimit = i + 1;
            }else{
                upperLimit = i - 1;
                if(min > i){
                    min = i;
                }
            }


        }
        
        return min;

    }
}
