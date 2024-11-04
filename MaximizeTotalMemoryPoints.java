/*
 * Problem Statement:
 * 
 * You are given a list of memory points representing the amount of memory you can gain from each task.
 * You want to maximize the total memory points by completing the tasks in an optimal order.
 * The total memory points is calculated by adding the cumulative sum of the memory points obtained
 * after each task is completed.
 * 
 * Given a list of n memory points, find the maximum total memory points you can achieve.
 * 
 * Example:
 * Input:
 * 4            // Number of tasks
 * 4 3 2 1      // Memory points for each task
 * 
 * Output:
 * 20
 * 
 * Explanation:
 * Sorting the tasks in descending order gives [4, 3, 2, 1].
 * The cumulative memory points after each task are [4, 7, 9, 10].
 * Adding these values together gives the maximum total memory points of 20.
 * 
 * Function Signature:
 * public static long maximizeTotalMemoryPoints(List<Integer> memory)
 */

 import java.util.Collections;
 import java.util.List;
 import java.util.Scanner;
 import java.util.ArrayList;
 
 public class MaximizeTotalMemoryPoints {
 
     public static long maximizeTotalMemoryPoints(List<Integer> memory) {
         // Sort the list in descending order
         memory.sort(Collections.reverseOrder());
 
         long total = 0;
         long cumulativeSum = 0;
 
         // Use enhanced for-loop for efficiency
         for (int m : memory) {
             cumulativeSum += m;    // Add the current element to cumulative sum
             total += cumulativeSum; // Add cumulative sum to total
         }
 
         return total; // Return the total memory points
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         // Read the number of elements
         int n = scanner.nextInt();
         List<Integer> memory = new ArrayList<>(n);
 
         // Directly read and add elements to memory list
         for (int i = 0; i < n; i++) {
             memory.add(scanner.nextInt());
         }
 
         // Print the result
         System.out.println(maximizeTotalMemoryPoints(memory));
         scanner.close(); // Close the scanner to prevent resource leak
     }
 }
