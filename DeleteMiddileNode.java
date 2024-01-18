/*
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
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
class DeleteMiddleNode{
    public ListNode deleteMiddle(ListNode head) {
        ListNode cur = head;
        ListNode mid = cur;
        ListNode prev = new ListNode();
        int i=0;
        while(cur.next!=null){
            i++;
            if(i%2==0){
                prev=mid;
                mid=mid.next;
            }
            cur=cur.next;
        }
        if(i==0){
            return null;
        }
        else if(i%2==0){
            prev.next = mid.next;
        }
        else{
            mid.next = mid.next.next;
        }
        return head;

        
    }
}