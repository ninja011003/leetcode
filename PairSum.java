import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PairSum {
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int max=Integer.MIN_VALUE,n=arr.size();
        for(int i=0;i<=n/2;i++){
            max=Math.max(max,arr.get(i)+arr.get(n-i-1));
        }
        return max;
    }
}
