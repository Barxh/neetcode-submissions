class Solution {
    public boolean isPalindrome(String s) {
        char[] sec = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for( char c : sec){
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')) sb.append(Character.toLowerCase(c));
        }
        System.out.print(sb);
        int i = 0;
        int j = sb.length()-1;
        while(i<j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
