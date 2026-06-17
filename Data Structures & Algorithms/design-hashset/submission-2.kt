class MyHashSet() {
    var arr = Array(10) {LinkedList<Int>()}
    var size = 0
    fun add(key: Int) {
        if(size == arr.size){
            createNewArr()
        }
        if(!arr[key%arr.size].contains(key)){
            arr[key%arr.size].add(key)
        }
    }

    fun remove(key: Int) {
        arr[key%arr.size].remove(key)
    }

    fun contains(key: Int): Boolean {
        return arr[key%arr.size].contains(key)
    }

    private fun createNewArr(){
        var newSize = arr.size + arr.size/2
        val newArr = Array(newSize) {LinkedList<Int>()}
        for(list in arr){
            list.forEach{ num ->
                newArr[num%newSize].add(num)
            }
        }
        arr = newArr
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
