/* You are given a 0-indexed integer array nums. You are allowed to permute nums into a new array perm of your 
choosing. We define the greatness of nums be the number of indices 0 <= i < nums.length for which perm[i] > nums[i].
Return the maximum possible greatness you can achieve after permuting nums.
* Eg 1 :  nums = [1,3,5,2,1,3,1]    perm = [2,5,1,3,3,1,1]     Greatness = 4
* Eg 2 :  nums = [1,2,3,4]          perm = [2,3,4,1]           Greatness = 3
*/
import java.util.*;
public class Beauty
{
      public int MaximumGreatness(int nums[])
      {
            PriorityQueue<Integer> MinHeap = new PriorityQueue<Integer>();    //* MinHeap -> O(N)
            for(int i = 0; i < nums.length; i++)     //! Storing data in MinHeap -> O(N)
                  MinHeap.add(nums[i]);
            Arrays.sort(nums);       //! Sorting -> O(N log N)
            int greatness = 0, index = 0;
            while(!MinHeap.isEmpty())        //! Comparison -> O(N)
            {
                  if(MinHeap.peek() > nums[index])   // If the first element of MinHeap is greater than nums...
                  {
                        greatness++;   // Increase greatness counter...
                        index++;     // Increase the index of the nums...
                  }
                  MinHeap.remove();
            }
            return greatness;    // Return the Greatness value...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter length of the array : ");
            x = sc.nextInt();
            int array[] = new int[x];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter data : ");
                  array[i] = sc.nextInt();
            }
            Beauty beauty = new Beauty();    // Object creation...
            System.out.println("The Maximum Greatness of the Array : "+beauty.MaximumGreatness(array));
            sc.close();
      }
}



//! Time Complexity -> O(N log N)
//* Space Complexity -> O(N)
// 1. After Sorting we can check for which values we can have strictly greater element...