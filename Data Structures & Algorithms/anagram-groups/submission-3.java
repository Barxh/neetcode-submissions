class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lista = new ArrayList<List<String>>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i< strs.length; i++){
            char[] pom = strs[i].toCharArray();
            Arrays.sort(pom);
            String key = new String(pom);
            if(map.containsKey(key)){
                lista.get(map.get(key)).add(strs[i]);
            }else{
                List<String> novaLista = new ArrayList<>();
                novaLista.add(strs[i]);
                lista.add(novaLista);
                map.put(key, lista.size()-1);
            }
        }
        return lista;
    }
}
