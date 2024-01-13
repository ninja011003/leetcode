/*
 * https://leetcode.com/problems/number-of-recent-calls/submissions/1145271970/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
public class RecentCounter {
    Queue<Integer> logs;
    public RecentCounter() {
            logs= new LinkedList<>();
    }
    
    public int ping(int t) {
        logs.add(t);
        while(t-logs.peek()>3000){
            logs.poll();
        }
        return logs.size();
    }
}
