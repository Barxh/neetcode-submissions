class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sCheck = new int[26];
        int[] tCheck = new int[26];

        for(int i = 0; i < s.length(); i++){
            sCheck[s.charAt(i) - 'a'] += 1;
            tCheck[t.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < 26; i++){
            if(sCheck[i] != tCheck[i]) return false;
        }
        return true;
    }
}
