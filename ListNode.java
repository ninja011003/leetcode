import java.util.*;
public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public static void PrintLinkedList(ListNode head){
            Set<String> visitedNode = new HashSet<>();
            while(head.next!=null){
                if(visitedNode.contains(head.toString())){
                    System.out.println("\nCycle Found !!!");
                    return;
                }else{
                    System.out.print(head.val+"-->");
                    visitedNode.add(head.toString());
                    head=head.next;
                }
            }
            System.out.println(head.val);
        }
        public static ListNode ArrToLinkedList(int[] arr){
            ListNode head = new ListNode(arr[0]);
            ListNode cur = head;
            for(int i=1;i<arr.length;i++){
                ListNode newNode = new ListNode(arr[i]);
                cur.next=newNode;
                cur=cur.next;
            }
            return head;
        }
    }