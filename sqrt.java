/*
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *You must not use any built-in exponent function or operator.
 *For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
class sqrt{
    public static int mySqrt(int x) {
        int n=0;
        while(n*n<=x){
            if(n==46340)
                return n;
            n++;
        }
        return n-1;
    }
    public static void main(String[] args) {
        //System.out.println(mySqrt(8));
       //System.out.println(46340*46340);
        System.out.println(mySqrt(2147395600));
    }
}