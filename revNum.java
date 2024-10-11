public class revNum {
    public static int revNumber(int n){
        int rev = 0;
        while(n>0){
            int reminder = n%10;
            n/=10;
            rev=rev*10 +reminder;
        }
        return rev;

    }
    public static void main(String[] args) {
        System.out.println(revNumber(12045));
    }
}
