import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }
        if(digits[0]==0){
            digits=Arrays.copyOf(digits, digits.length+1);
            digits[0]=1;
        }
        return digits;
    }
    public static void main(String[] args) {
        /* 
        int[] a = {1, 2, 3};
        // make a copy
        a = Arrays.copyOf(a, a.length + 1);
        //a= new int[a.length+1]; //will assign all values to be zero
        for (int i : a)
            System.out.println(i);
        */
        /* 
        int[] a={9};
        System.out.println(plusOne(a).toString());
        */
    }
}
