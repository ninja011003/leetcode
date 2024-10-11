import java.util.*;
import java.util.LinkedList;
public class treeProvinces {
    public static void traverse(int cur,Set<Integer> path,int[][] isConnected){
        for(int i =0;i<isConnected[cur].length;i++){
            if(path.contains(i)){
                continue;
            }
            if(isConnected[cur][i]==1){
                path.add(i);
                traverse(i, path, isConnected);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        List<Set<Integer>> prov = new LinkedList<>();
        for(int i =0;i<isConnected.length;i++){
            boolean visited= false;
            for(Set<Integer> s : prov){
                visited = s.contains(i);
                if(visited)
                    break;
            }
            if(!visited){
                Set<Integer> temp = new LinkedHashSet<>();
                temp.add(i);
                traverse(i,temp, isConnected);
                prov.add(temp);
            }
        }
        // System.out.println(prov);
        return prov.size();
    }


    public static void main(String[] args) {
        int[][] graph = {{1,1,0},{1,1,0},{0,0,1}};
        // int[][] graph = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] arr = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
        };
        System.out.println(findCircleNum(arr));
    }

}
