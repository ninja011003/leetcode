import java.util.Arrays;

public class only14 {
    
    public static void main(String[] args) {
        int[] a = {1,10,23,10,18};
        int[] b = new int[a.length];
        int k=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=10){
                b[k]=a[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(b));
        
    }
}
