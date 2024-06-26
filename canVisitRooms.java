/*
 * https://leetcode.com/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class canVisitRooms {
    public static void travel2Rooms(Set<Integer> visitedRooms,List<List<Integer>> rooms,int currentRoom){
        if(visitedRooms.contains(currentRoom)){
            return;
        }
        else{
            visitedRooms.add(currentRoom);
            for(Integer room : rooms.get(currentRoom)){
                travel2Rooms(visitedRooms, rooms, room);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        travel2Rooms(visitedRooms, rooms, 0);
        return visitedRooms.size()==rooms.size();
    }
}
