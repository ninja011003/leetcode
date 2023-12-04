public class canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(len==1){
            if(n==0)
                return true;
            if(n>1)
                return false;
            if(n==1&&flowerbed[0]==0){
                return true;
            }
            else{
                return false;
            }
        }
        
        if(len>1&&flowerbed[0]==0&&flowerbed[1]==0&&n!=0){
            flowerbed[0]=1;
            n--;
        }
        if(len>1&&flowerbed[len-1]==0&&flowerbed[len-2]==0&&n!=0){
            flowerbed[len-1]=1;
            n--;
        }
        for(int i=1;i<len-1&&n>0;i++){
            if(flowerbed[i]==0){
                if(flowerbed[i-1]==0&&flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n==0;
    }
}
