import java.util.Scanner;

public class GoodString {
    public static int goodDistanceComputer(String good_str,String name){
        Character preGoodLetter = good_str.charAt(0);
        int distance=0;
        for(int i=0;i<name.length();i++){
            int min=Integer.MAX_VALUE;
            int count =0;
            Character c = name.charAt(i);
            Character[] eq_d = new Character[good_str.length()];
            Character bestCharacter=preGoodLetter;
            for(int j=0;j<good_str.length();j++){
                if(Math.abs(c-good_str.charAt(j))==min){
                    count++;
                    eq_d[count]=good_str.charAt(j);
                }
                else if(Math.abs(c-good_str.charAt(j))<min){
                    min=Math.abs(c-good_str.charAt(j));
                    eq_d = new Character[good_str.length()];
                    count=0;
                    eq_d[count]=good_str.charAt(j);
                }
            }
            if(count>0){
                int temp_min=Integer.MAX_VALUE;
                for(int k=0;k<=count;k++){
                    if(Math.abs(eq_d[k]-preGoodLetter)<temp_min){
                        bestCharacter=eq_d[k];
                        temp_min=Math.abs(eq_d[k]-preGoodLetter);
                    }
                }
                distance+=Math.abs(preGoodLetter-bestCharacter);
                preGoodLetter= bestCharacter;
            }else{
                distance+=Math.abs(c-eq_d[0]);
            }

        }
        return distance;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String good_str = sc.next();
        String name = sc.next();
        System.out.println(goodDistanceComputer(good_str, name));
        sc.close();
    }
}
