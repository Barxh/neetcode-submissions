class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            for(char c : s.toCharArray()){
                if(c == (char)0){
                    sb.append((char)255);
                }else{
                    sb.append((char)(c - 1));
                }
            }
            sb.append((char) 0);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> novaLista = new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        for(char c : str.toCharArray()){
            if(c == 255){
                sb.append((char) 0);
            }else if(c == 0){
                novaLista.add(sb.toString());
                sb.setLength(0);
            }else{
                sb.append((char)(c + 1));
            }
        }
        return novaLista;
    }
}
