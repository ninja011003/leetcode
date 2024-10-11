    public class c2 {
        public static int nextSuv(int i,int[] arr){
            int next =i+1;
            next = next%arr.length;
            while(arr[next]!=0){
                next = (next+1)%arr.length;
            }
            return next;
        }
        
        public static int findSurvivor(int cur,int[] arr){
            while(cur!=nextSuv(cur, arr)){
                arr[nextSuv(cur, arr)]=1;
                cur = nextSuv(cur, arr);
            }
            return cur+1;
        }
        public static void main(String[] args) {
            int[] arr = new int[100];
            System.out.println(findSurvivor(0, arr));

        }
    }
