import java.util.ArrayList;
import java.util.List;

public class eliminateNext {
    
    public static int findSurvivor(int n){
        List<Integer> people = new ArrayList<>();
        for(int i=1;i<=n;i++){
            people.add(i);
        }
        int currentKiller=0;
        while(people.size()>1){
            int kill = (currentKiller+1)%people.size();
            people.remove(kill);
            if(kill<people.size()){
                currentKiller=kill;
            }
            else{
                currentKiller=0;
            }
        }
        return people.get(0);
    }
    public static int findOnlySurvivor(int n){
        List<Integer> people = new ArrayList<>();
        for(int i=1;i<=n;i++){
            people.add(i);
        }
        int currentKiller=0;
        while (people.size()>0) {
            if(currentKiller<people.size()){
                people.remove(currentKiller+1);
            }
            else{
                currentKiller=0;
            }
            currentKiller++;
            
        }
    }
    public static void main(String[] args) {
       System.out.println(findSurvivor(100));
    }
}
    