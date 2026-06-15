class Solution {
    public boolean isValid(String s) {
        Set<Character> otvoreneZagrade = Set.of('(', '[', '{');
        HashMap<Character, Character> zatvoreneZagrade = new HashMap<>(
        Map.of(')', '(', ']', '[', '}', '{'));
        Deque<Character> red = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char currentChar =  s.charAt(i);
            if(zatvoreneZagrade.containsKey(currentChar)){
                
                if(zatvoreneZagrade.get(currentChar) == red.peek()){
                    
                    red.pop();
                }else{
                    return false;
                }
            }else{
                red.push(currentChar);
            }
        }
        if(red.size() == 0){
            return true;
        }
        return false;
    }
}
