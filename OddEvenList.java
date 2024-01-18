/*
 * class ListNode implementation is given in ListNode.java file in the same github directory!! 
 * https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 */

class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if(head==null){return null;}
        ListNode curOddHead = head;
        ListNode curEvenhead = head.next;
        ListNode initialEvenHead=curEvenhead;
        while(curOddHead.next!=null&&curEvenhead.next!=null){
            curOddHead.next=curOddHead.next.next;
            curEvenhead.next = curEvenhead.next.next;
            curOddHead=curOddHead.next;
            curEvenhead = curEvenhead.next;
        }
        curOddHead.next=initialEvenHead;
        return head;
    }
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6};
        ListNode head= ListNode.ArrToLinkedList(a);
        ListNode.PrintLinkedList(head);
        ListNode.PrintLinkedList(oddEvenList(head));;
    }
}
