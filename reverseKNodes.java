import java.util.*;
public class reverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tempHead =head;
        while(stack.size()<k){
            if(tempHead!=null){
                stack.add(tempHead);
                tempHead=tempHead.next;
            }
            else{
                return head;
            }
        }
        ListNode returningNode = stack.pop();
        ListNode temp = returningNode;
        while(stack.size()>0){
            temp.next = stack.pop();
            temp=temp.next;
        }
        temp.next = reverseKGroup(tempHead, k);
        return returningNode;
    }
}
