class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            System.out.println("i: " + i + ", j: " + j);
            while(i < j && !isLetter(s.charAt(i))) i++;
            while(j > i && !isLetter(s.charAt(j))) j--;
            if(j<i) return true;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isLetter(char c){
        if((c>= 'a' && c<= 'z') || (c >= 'A' && c<='Z') || (c>='0' && c<='9')) {
            System.out.println("Zeznuo si");
            return true;
        }
        System.out.println("Nisi Zeznuo ");
        return false; 
    }
}
