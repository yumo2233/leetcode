import java.util.HashMap;

/**
 * @author Pzr
 * @create 2022/5/24 - 19:49
 */
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
        HashMap<Node,Node> hashmap = new HashMap();
        Node p = head,q;
        while(p!=null){
            q = new Node(p.val);
            hashmap.put(p,q);
            p = p.next;
        }
        p = head;
        q = hashmap.get(p);
        while(p!=null){
            q.next = hashmap.get(p.next);
            q.random = hashmap.get(p.random);
            p = p.next;
            q =q.next;
        }
        return hashmap.get(head);
    }//标签为 7 的节点未被复制，而是对原始节点的引用。
}
