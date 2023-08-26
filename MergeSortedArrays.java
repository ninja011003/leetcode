/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *Merge nums1 and nums2 into a single array sorted in non-decreasing order.

 *The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

public class MergeSortedArrays {
   public void merge(int[] nums1, int m, int[] nums2, int n) {
      int i = 0, j = 0, k = 0;
      int new_arr[] = new int[m + n];
      while (i < m && j < n) {
         if (nums1[i] <= nums2[j]) {
            new_arr[k] = nums1[i];
            i++;
         } else {
            new_arr[k] = nums2[j];
            j++;
         }
         k++;
      }
      while (i < m) {
         new_arr[k] = nums1[i];
         k++;
         i++;
      }
      while (j < n) {
         new_arr[k] = nums2[j];
         k++;
         j++;
      }
      System.arraycopy(new_arr, 0, nums1, 0, m+n);
   }
}
