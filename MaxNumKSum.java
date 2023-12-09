/*
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
        
public class MaxNumKSum{

    // MY WORST SOLUTION EVER!!!!!!!!!!!!!!!!
    public static int BinSearch(List<Integer> arr,int low,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            int temp=arr.get(mid);
            if(temp==target){
                return mid;
            }
            else if(temp>target){
                return BinSearch(arr,low,mid-1,target);
            }
            else{
                return BinSearch(arr,mid+1,high,target);
            }
        }
        return -1;
    }
    public static int maxOperations(Integer[] nums, int k) {
        Arrays.sort(nums);
        int count=0;
        List<Integer> arr = new ArrayList<>();
        System.out.println(nums.length);
        for(int i : nums){
            if(i>=k){
                break;
            }
            arr.add(i);
        }
        for(int i=0;i<arr.size();i++){
            int index=0;
            if(2*arr.get(i)==k&&arr.get(i)==arr.get(i+1)){
                count++;
                arr.remove(i+1);
                arr.remove(i);
                i--;
                continue;
            }
            else{
                index=BinSearch(arr, 0, arr.size()-1, k-arr.get(i));
            }
            if(index!=-1){
                if(i==index)
                    continue;
                else if(i<index){
                    count++;
                    System.out.println(count+":- "+arr.get(i)+":"+arr.get(index));
                    arr.remove(index);
                    arr.remove(i);
                    i--;
                }
                else{
                    count++;
                    System.out.println(count+":- "+arr.get(i)+":"+arr.get(index));
                    arr.remove(i);
                    arr.remove(index);
                    i--;
                }
                
            }
            else{
                if(i!=0){
                    while(i!=arr.size()-1&&arr.get(i)==arr.get(i+1)){
                        i++;
                    }
                }
            }
        }
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+",");
        }
        return count;
    }
    public static void main(String[] args) {
            try {
            // Specify the file path
            File file = new File("testcase.csv");

            // Create a Scanner to read from the file, using comma as the delimiter
            Scanner scanner = new Scanner(file).useDelimiter(",");

            // Create a list to store integers
            List<Integer> integerList = new ArrayList<>();

            // Read integers from the file and add them to the list
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                integerList.add(num);
            }

            // Convert the list to an array
            Integer[] integerArray = integerList.toArray(new Integer[0]);

            // Print the array (optional)
            // for (int num : integerArray) {
            //     System.out.print(num + " ");
            // }

            // Close the scanner
            scanner.close();
            System.out.println(maxOperations(integerArray, 88));
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        
    }
}