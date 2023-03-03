public class RomanToInt {
    public static String romantoString(int num){
        StringBuffer ans = new StringBuffer();
        while(num>0){
            while(num>=1000){
                ans.append("M");
                num-=1000;
            }
            if(num>=900){
                ans.append("CM");
                num-=900;
                continue;
            }
            if(num>=500){
                ans.append("D");
                num-=500;
                continue;
            }
            if(num>=400){
                ans.append("CD");
                num-=400;
                continue;
            }
            while(num>=100){
                ans.append("C");
                num-=100;
            }
            if(num>=90){
                ans.append("XC");
                num-=90;
                continue;
            }
            if(num>=50){
                ans.append("L");
                num-=50;
                continue;
            }
            if(num>=40){
                ans.append("XL");
                num-=40;
                continue;
            }
            while(num>=10){
                ans.append("X");
                num-=10;
                continue;
            }
            if(num>=9){
                ans.append("IX");
                num-=9;
                return ans.toString();
            }
            if(num>=5){
                ans.append("V");
                num-=5;
                continue;
            }
            if(num==4){
                ans.append("IV");
                num-=4;
                return ans.toString();
            }
            while(num>=1){
                ans.append("I");
                num-=1;
            }
        }
        //System.out.print(ans.toString());
        return ans.toString();
    }
    public static void main(String[] args) {
        romantoString(401);
    }
}
