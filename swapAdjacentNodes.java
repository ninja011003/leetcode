
public class swapAdjacentNodes {
    public static ListNode swapPairs(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode returnNode=head.next;
            ListNode prev = head;
            ListNode cur=head;
            while(cur.next!=null){
                ListNode temp =cur.next;
                cur.next=temp.next;
                temp.next =cur;
                prev=temp;
                prev=cur;
                cur=cur.next;

            }
            return returnNode;
    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        swapPairs(ListNode.ArrToLinkedList(arr));
    }
}

