/**
 * @author Pzr
 * @create 2022/5/24 - 19:22
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;//
        }
        int n = 1;
        ListNode curr = head;
        while(curr.next!=null){
            n++;
            curr = curr.next;
        }
        curr.next = head;
        for(int i = 1;i <= n - k%n - 1;i++){
            head = head.next;
        }
        curr = head.next;
        head.next = null;
        return curr;
    }
}
