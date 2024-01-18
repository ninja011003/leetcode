/*
 * https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 */
import java.util.*;
class Senate{
    public static String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        Set<Integer> bannedSenate = new HashSet<>();
        for(int i=0;i<senate.length();i++){
            // System.out.println(senate);
            if(queue.isEmpty()){
                queue.add(senate.charAt(i));
            }
            else if(senate.charAt(i)=='R'){
                if(queue.peek()=='R'){
                    queue.add('R');
                }
                
                else{
                    queue.poll();
                    bannedSenate.add(i);
                }
            }
            else{
                if(queue.peek()=='D'){
                    queue.add('D');
                }
                else{
                    queue.poll();
                    bannedSenate.add(i);
                }
            }
            int r=0,d=0;
            if(i==senate.length()-1){
                i= -1;
                StringBuffer str = new StringBuffer("");
                for(int k=0;k<senate.length();k++){
                    if(!bannedSenate.contains(k)){
                        str.append(senate.charAt(k));
                        if(senate.charAt(k)=='R'){
                            r++;
                        }
                        else{
                            d++;
                        }
                    }
                }
                senate=str.toString();
                bannedSenate.clear();
                if(r==0||d==0){
                    break;
                }
            }
        }
        if(senate.charAt(0)=='R'){
            return "Radiant";
        }
        else{
            return "Dire";
        }
    }
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRDRR"));
    }
}