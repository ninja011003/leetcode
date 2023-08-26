import java.util.HashMap;

public class ClimbingStairs{
    public static int climbStairs(int n) {
        HashMap<Integer,Integer> data = new HashMap<>();
        return combinationComputer(data,0, n);
    }

    public static int combinationComputer(HashMap<Integer,Integer> data,int curStair,int desStair){
        if(curStair>desStair){
            return 0;
        }
        else if(curStair==desStair){
            return 1;
        }
        else if(data.containsKey(curStair)){
            return data.get(curStair);
        }
        else{
            data.put(curStair,combinationComputer(data, curStair+1, desStair)+combinationComputer(data, curStair+2, desStair));
            return data.get(curStair);
        }
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}


