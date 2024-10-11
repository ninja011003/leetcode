class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
public class LinkedList {
    public static void addToIndex(Node head,int value, int index){
        int i =0;
        while(head.next!=null&&i<index){
            head=head.next;
        }
        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next=newNode;
    }
    public static void main(String[] args) {
        
    }
}
