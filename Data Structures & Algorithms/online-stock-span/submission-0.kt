import kotlin.collections.ArrayDeque
class StockSpanner() {
    data class Stock(val price: Int, var span: Int)
    private val deque = ArrayDeque<Stock>()
    fun next(price: Int): Int {
        val newStock = Stock(price, 1)
        var i = deque.lastIndex
        while(i >= 0){
            if(deque[i].price <= price){
                newStock.span += deque[i].span
                i -= deque[i].span
            }else{
                break
            }
        }
        deque.addLast(newStock)
        return newStock.span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
