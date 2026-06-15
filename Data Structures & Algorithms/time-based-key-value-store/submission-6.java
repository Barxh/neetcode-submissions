class TimeMap {

    record User(String value, int timestamp) {}
    HashMap<String, List<User>> users;

    public TimeMap() {
        users = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        users.computeIfAbsent(key, k ->new ArrayList<>()).add(new User(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<User> lista = users.get(key);
        if(lista == null) return "";
        int l = 0;
        int r = lista.size();
        int closest = timestamp - lista.get(0).timestamp();
        String closestString = lista.get(0).value();
        while(l < r){
            int m = l + (r-l) / 2;
            User u = lista.get(m);
            if(u.timestamp() == timestamp){
                return u.value();
            }else if(timestamp > u.timestamp()){
                l = m + 1; 
            }else{
                r = m;
            }
            if(closest > timestamp - u.timestamp() && u.timestamp() < timestamp){
                closest = timestamp - u.timestamp();
                closestString = u.value();
            }
        }
        if(closest < 0) return "";
        return closestString;
        
    }
}
