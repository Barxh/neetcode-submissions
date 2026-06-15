/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        // Mapa mapira ORIGINALNI čvor -> KLONIRANI čvor
        // Služi i kao 'visited' struktura
        val map = HashMap<Node, Node>()
        val queue = ArrayDeque<Node>()

        // Kloniramo početni čvor i stavljamo original u red
        map[node] = Node(node.`val`)
        queue.offer(node)

        while (queue.isNotEmpty()) {
            val curr = queue.poll()

            // Prolazimo kroz sve komšije ORIGINALNOG čvora
            for (neighbor in curr.neighbors) {
                if (neighbor == null) continue

                // Ako komšija još nije kloniran (nije posećen)
                if (!map.containsKey(neighbor)) {
                    // Kloniramo ga
                    map[neighbor] = Node(neighbor.`val`)
                    // Stavljamo ORIGINALNOG komšiju u red da bismo kasnije obradili njegove veze
                    queue.offer(neighbor)
                }

                // Povezujemo klonirane čvorove:
                // U listu komšija klona trenutnog čvora dodajemo kloniranog komšiju
                map[curr]?.neighbors?.add(map[neighbor])
            }
        }

        return map[node]
    }
}
