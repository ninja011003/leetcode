public class removeDuplicate {
    public static void main(String[] args) {
        int[] arr = {12,34,12,45,67,12,89};
        boolean isDuplicate=false;
        for(int i=0;i<arr.length;i++){
            isDuplicate=false;
            for(int j=i-1;j>=0;j--){
                if(arr[i]==arr[j]){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                System.out.println(arr[i]);
            }
        }

    }
}
