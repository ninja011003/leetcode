import java.util.*;
import java.util.LinkedList;


public class ab {
    //example of a recursive func

    public static void reverseString(String s,int i){
        if(i>=s.length()){
            return;
        }
        System.out.print(s.charAt(s.length()-i-1));
        reverseString(s, ++i);
    }
    
    public static void main(String[] args) {
        // //string
        // String str ;
        // str = new String("hello");

        // str.equals(str);//boolean
        // str.length();//int
        // str.charAt(0);//char 
        // char[] str_arr = str.toCharArray(); //char[] converts string to char array
        // System.out.println(str_arr[0]); 
        // System.out.println(str.indexOf("l"));//int  
        // System.out.println(str.lastIndexOf("l"));;//int
        // System.out.println(str.substring(0,5));;//String
        // System.out.println(str);
        // // int[] arr = {1,2,3,null};
        // // Integer[] arr2 ={2,null};
        // str =str.replace(str, str);
        // System.out.println(str);
        // StringBuffer  s = new StringBuffer("hello");
        // System.out.println(s.reverse().toString());

        // s.append("s");
        // System.out.println(s.toString());
        // String[] strs ={"abs","bbb"};
        // for(String c: strs){
        //     //do nothing
        //     System.out.println(c);
        // }

    

        // //recursion
        // reverseString("ahtiba", 0);
        // //n =6
        // // a b i t h i
        // // 0 1 2 3 4 5
        // for(int i =0;i<s.length();i++){
        //     System.out.println(s.charAt(n-i-1));
        // }
        // create a 2d matrix for a rat maze problem
        //{
        //  {1,0,0,0},
        //  {1,1,0,1},
        //  {1,1,0,0},
        //  {0,1,1,1}
        //}
        
        //collections
        //arraylist - dynamic array
        //set - unique element - remove duplicates
        //map - key-value pair
        //hashmap - key-value key-->hashvalue--> value is mapped - faster retrieval
        //linked list - value,nextNode pair
        //list - Interface -> ArrayList, LinkedList
        //stack - LIFO - push,pop,peek
        //queue - FIFO - enqueue,dequeue,peek


        //arraylist
        // ArrayList<Integer> arr = new ArrayList<>();//sequential
        // arr.size();//returns size
        // arr.add(11);
        // arr.get(0);//returns element
        // arr.add(22);//add element
        // // arr.remove(1);//remove element
        // arr.set(1,11);//set element
        
        // arr.add(1,27);
        // arr.remove(1);
        // System.out.println(arr.contains(3));
        // System.out.println(Arrays.toString(arr.toArray()));
        // System.out.println(arr.indexOf(11));
        // // System.out.println(arr.lastIndexOf(11));
        // List<Integer> list  = new LinkedList<>();
        // list.addAll(arr);
        // LinkedList<Integer> ll = new LinkedList<>();
        // int[] arr = {1,2,3,4,5};
        // ListNode  head = ListNode.ArrToLinkedList(arr);
        // ListNode.PrintLinkedList(head);

        // LinkedList<Integer> ll = new LinkedList<>();
        // List<Integer> a = new ArrayList<>();
        // a.add(3);
        // a.add(4);
        // ll.add(1);
        // ll.add(2);
        // ll.add(3);
        // ll.add(4);
        // ll.add(5);
        // System.out.println(ll);
        // ll.removeLast();
        // ll.remove(0);
        // System.out.println(ll.containsAll(a));
        // System.out.println(ll);
        // LinkedList l2= (LinkedList)ll.clone();
        // System.out.println(l2);
        // System.out.println(ll.peekLast());
        // ll.pop();
        

        int rows = 5;
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }

        int[] a = new int[2];
        System.out.println(a);


    }

}
