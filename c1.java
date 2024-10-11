import java.util.*;


/*/**
 *  2 3 4 5
 */

public class c1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]= Integer.parseInt(nums[i]);
        }
        System.out.print(Arrays.toString(arr));

    }
}
