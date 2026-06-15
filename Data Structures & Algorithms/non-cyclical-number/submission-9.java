class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        while(true){

            int sum = (num%10) * (num%10);
            System.out.println(sum + "sada" + num%10);
            for(int i = 10, j = 100; num / i > 0; i*=10, j *=10){
                sum += ((num%j)/i) * ((num%j)/i);
            }
            if(sum == 1){
                return true;
            }else{
                System.out.println(sum);
                if(set.contains(sum)) break;
                num = sum;
                set.add(sum);
            }

        }
        return false;
    }
}
