import java.util.ArrayList;
import java.util.List;
//fjffefefef
public class calculatePascal {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        temp.add(1);
        ans.add(temp);

        for(int i=1;i<numRows;i++){
            temp= new ArrayList<>();
            temp.add(1);
            for(int j =1;j<i;j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            temp.add(1);
            prev=temp;
            ans.add(temp);
        }
        return ans;
    }
}
//2f2-9hg-vj-   jv
