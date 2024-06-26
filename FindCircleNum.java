import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

/*
 * 1 1 0
 * 1 1 0
 * 0 0 1
 */
public class FindCircleNum{
    // public static List<Set<Integer> cycles = new ArrayList<>();
    public static void dfs(Set<Integer> visited,int curNode,int[][] isConnected,List<Set<Integer>> cycles){
        if(!visited.contains(curNode)){
            visited.add(curNode);
            if(cycles.size()==0){
                Set<Integer> cycle = new HashSet<>();
                for(int i =0;i<isConnected[curNode].length;i++){
                    if(isConnected[curNode][i]==1){
                        cycle.add(i);
                    }
                }
                cycles.add(cycle);
            }
            else{
                for(Set<Integer> cycle :cycles){
                    if(cycle.contains(curNode)){
                        for(int i =0;i<isConnected[curNode].length;i++){
                            if(isConnected[curNode][i]==1){
                                cycle.add(isConnected[curNode][i]);
                            }
                        }
                    }
                }
            }
            for(int i =0;i<isConnected[curNode].length;i++){
                if(isConnected[curNode][i]==1){
                    dfs(visited, i, isConnected, cycles);
                }
            }
        
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        List<Set<Integer>> cycles = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i =0;i<isConnected.length;i++){
            dfs(visited, i, isConnected, cycles);
        }
        for(Integer i : visited){
            System.out.print(i);
        }
        System.out.println("\n-----------");
        for(Set<Integer> cycle : cycles){
            for(Integer i: cycle){
                System.out.print(i);
            }
            System.out.println();
        }
        return cycles.size();
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));

    }
}