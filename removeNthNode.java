public class removeNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i=0,len=0;
        ListNode cur = head,prev=null;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        cur=head;
        while(i<len-n){
            prev=cur;
            cur=cur.next;
            i++;
        }
        if(prev==null){
            return head.next;
        }
        else if(cur==null){
            prev.next=null;
        }
        else{
            prev.next=cur.next;
        }
        return head;
    }
}
