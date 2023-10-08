import java.util.LinkedHashSet;
import java.util.Set;

public class exam {
    public static void triangle_pattern(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void freq_computer(int[] arr){
        Set<Integer> nums = new LinkedHashSet<>();
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int count =0;
            if(nums.contains(num)){
                continue;
            }
            else{
                nums.add(num);
            }
            for(int j=0;j<arr.length;j++){
                if(arr[j]==num)
                    count++;
            }
            System.out.println(num+" : "+count);
        }
    }
    public static String longest_common_prefix(int n,String[] arr){
        StringBuffer str = new StringBuffer("");
        for(int i=0;i<arr[0].length();i++){
            char c = arr[0].charAt(i);
            for(int j=1;j<n;j++){
                if(i>=arr[j].length()){
                    return str.toString();
                }
                if(c!=arr[j].charAt(i)){
                    return str.toString();
                }
            }
            str.append(c);
        }
        return str.toString();
    }
    public static boolean bin_search(int[] arr,int target,int low,int high){
        while(low<=high){
            int mid=low +(high-low)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]>target){
                return bin_search(arr, target, low, mid-1);
            }
            else if(arr[mid]<target){
                return bin_search(arr, target, mid+1, high);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        triangle_pattern(4);
        int[] a ={1,1,3,4,3,5};
        freq_computer(a);
        String[] str = {"integer","interest","introduction"};
        System.out.println(longest_common_prefix(3, str));
        int[] arr ={1,1,3,4,5,9};
        System.out.println(bin_search(arr, 5, 0, 6));
    }
}
