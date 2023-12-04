/* Sample output (n=5)
 *         1 
         2 1 2 
       3 2 1 2 3 
     4 3 2 1 2 3 4 
   5 4 3 2 1 2 3 4 5 
 */

import java.util.*;

class virtusa_pattern{
    public static  void triangle_pattern(int n){
        for(int i=0;i<n;i++){
            for(int j=n-i-1;j>0;j--){
                System.out.print("  ");
            }
            for(int j=i+1;j>0;j--){
                System.out.print(j);
                System.out.print(" ");
            }
            for(int j=2;j<=i+1;j++){
                System.out.print(j);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
    public static int combinCom(int x,int op1,int op2){
        if(op1+op2==0){
            return 1;
        }
        else if(op1==0||op2==0){
            return 2;
        }
        else if(op1==op2){
            return 3;
        }
        else{
            return 4;
        }
    }
    public static int commaCounter(int num){
        if(num<=999){
            return 0;
        }
        int length = (""+num+"").length();
        if(length<=6){
            return num-999;
        }
        else if(length<=9){
            return num-999+(num-999999);
        }
        else{
            return num-999+(num-999999)+(num-999999999);
        }
    }
    public static int maximumScore(int N,int[] arr){
        int[]  sor_arr =  arr;
        Arrays.sort(sor_arr);
        return  Math.abs(sor_arr[0]-sor_arr[N-1])+Math.abs(sor_arr[1]-sor_arr[N-2]);
    }
    public static char maximizeGrade(String str,int position,int max_swap){
        char c = str.charAt(position);
        if(c=='a'){
            return 'a';
        }
        Set<Character> list = new HashSet<>();
        for(int i=position,j=0;i<str.length()&&j<=max_swap;i++,j++){
            list.add(str.charAt(i-1));
        }
        for(int i=position,j=0;i>0&&j<=max_swap;i--,j++){
            list.add(str.charAt(i-1));
        }
        for(Character e : list){
            // System.out.print(e);
            if(e<c){
                c=e;
            }
        }
        return c;
    }
    public static int leastDivNum(int input1,int input2){
        int start=input1,end=input2;
        if(input1>input2){
            start=input2;
            end=input1;
        }
        int num=0;
        for(int i=start;i<=end;i++){
            if(input1%i==0){
                // System.out.println(i);
                num=i;
                break;
            }
        }
        int sum=0;
        while(num>0){
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("enter a number: ");
        // triangle_pattern(sc.nextInt());
        // sc.close();;
        // int[] arr ={10,5,1,8,4};
        // System.out.println(maximumScore(5, arr));
        // System.out.println(maximizeGrade("abcdef", 2, 0));
        System.out.println(leastDivNum(18, 4));
    }
}

