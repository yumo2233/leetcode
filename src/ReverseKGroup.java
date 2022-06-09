/**
 * @author Pzr
 * @create 2022/6/9 - 17:26
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
//https://leetcode.cn/problems/reverse-nodes-in-k-group/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while(head != null){
            ListNode tail = pre;
            for(int i = 0;i < k;i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }
            ListNode[] reverse = Myreverse(head,tail);
            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            pre =  tail;
            head = tail.next;
        }
        return hair.next;
    }
    public ListNode[] Myreverse(ListNode head,ListNode tail){
        ListNode p = head;
        ListNode prev = tail.next;
        while(prev != tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
}
//配合Head一共用了三个逻辑指针（pre,head,tail）
//反转方法里用了三个指针，类似头插法