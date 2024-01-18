// https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=leetcode-75
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
public class ReverseLinkedList {
    public static ListNode top = null;
    public static ListNode reverseList(ListNode head) {
        ListNode prev=null,next=null;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        ListNode.PrintLinkedList(reverseList(ListNode.ArrToLinkedList(a)));
    }
}
