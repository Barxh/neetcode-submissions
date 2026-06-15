class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> red = new ArrayDeque<>();

        result[result.length - 1] = 0;
        red.push(temperatures.length - 1);
        for (int i = result.length - 2; i >= 0; i--) {
            while (red.size() > 0 && temperatures[i] >= temperatures[red.peek()]) {
                red.pop();
            }
            if(red.size() == 0){
                result[i] = 0;
            }else{
                result[i] = red.peek() - i;
            }


            red.push(i);
        }

        return result;
    }
}
