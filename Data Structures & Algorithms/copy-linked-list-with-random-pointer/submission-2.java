/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();

        Node pom = head;
        int i = 0;
        while(pom != null){
            if(i != 0){
                Node newNode = new Node(pom.val);
                list.add(newNode);
                list.get(i-1).next = newNode;
            }else{
                list.add(new Node(pom.val));
            }
            map.put(pom, i++);
            pom = pom.next;

        }
        pom = head;
        i = 0;
        while(pom != null){

            if(pom.random == null){
                list.get(i++).random = null;
            }else{
                list.get(i++).random=list.get(map.get(pom.random));
            }
            
            pom = pom.next;
        }
        return list.get(0);
    }
}
