/*
 *  https://leetcode.com/problems/divide-two-integers/
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
    The integer division should truncate toward zero, which means losing its fractional part.
    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
    Return the quotient after dividing dividend by divisor.
    Note: Assume we are dealing with an environment that could only store integers within
    the 32-bit signed integer range: [−231, 231 − 1].
    For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
    and if the quotient is strictly less than -231, then return -231.
 */

public class Divide {
    public static int divide(int dividend, int divisor) {
        long dividendL = dividend;
        long divisorL = divisor;
        long absDividendL= Math.abs(dividendL);
        long absDivisorL = Math.abs(divisorL);
        long quotient=0;
        if(absDivisorL!=1)
            while(absDividendL>=absDivisorL){
                absDividendL-=absDivisorL;
                quotient++;
            }
        else{
            quotient=absDividendL;
        }
        // long i=1;
        // while(i*absDivisorL<absDividendL){
        //     i*=2;
        // }
        // for(long j=i/2;j<=i;j++){
        //     if(j*absDivisorL==absDividendL){
        //         quotient=j;
        //         break;
        //     }
        //     if(j*absDivisorL>absDividendL){
        //         quotient= j-1;
        //         break;
        //     }
        // }
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
            quotient*=(-1);
        }
        if(quotient>2147483647){
            return 2147483647;
        }
        else if(quotient<-2147483648){
            return -2147483648;
        }
        else{
            return (int)quotient;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 2));
    }
}
