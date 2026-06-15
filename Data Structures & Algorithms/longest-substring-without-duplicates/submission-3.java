class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2 ) return s.length(); 
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 1;
        int max = 1;
        char[] charArray = s.toCharArray();
        set.add(charArray[i]);
        while(j < charArray.length){
            if(!set.contains(charArray[j])){
                set.add(charArray[j]);
                j++;
            }else{
                if(set.size() > max){
                    max = set.size();
                }
                do{
                   set.remove(charArray[i++]); 
                }while(set.contains(charArray[j]) && i<j);
                set.add(charArray[j]); 
                
                j++;
            }
        }
        if(set.size() > max){
            max = set.size();
        }
        return max;

    }
}
