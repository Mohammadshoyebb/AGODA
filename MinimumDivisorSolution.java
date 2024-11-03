// 2. Minimum Divisor
// Problem Statement:
// Given an array of integers, each element is to be divided by an integer so that the sum of the results is less than 
// or equal to a threshold integer. Each non-integer result of division is rounded up before it is added to the sum.
// For example, 1/9 = 0.111..., rounded up to 1.
// Determine the minimum divisor to make the sum less than or equal to the threshold.
//
// Example 1:
// Input:
// arr = [1, 5, 7]
// threshold = 8
// Output: 2
// Explanation:
// If the divisor is 1, the results are [1, 5, 7] which sums to 13, which is greater than the threshold 8.
// If the divisor is 2, the results are [1, 3, 4] which sums to 8, which is equal to the threshold 8.
// The minimum divisor to make the sum less than or equal to the threshold is 2.
//
// Example 2:
// Input:
// arr = [2, 4, 5]
// threshold = 10
// Output: 1
// Explanation:
// The smallest divisor to achieve a sum of divided elements within the threshold 10 is 1.
//
// Constraints:
// - 1 ≤ n ≤ 10^5
// - 1 ≤ threshold ≤ 10^9
// - 1 ≤ arr[i] ≤ 10^6

import java.util.*;

public class MinimumDivisorSolution {

    // Function to find the minimum divisor to keep the sum of division results <= threshold
    public static int minimumDivisor(List<Integer> arr, int threshold) {
        int left = 1; // Minimum possible divisor
        int right = findMax(arr); // Maximum element in the array as upper bound

        // Binary search to find the smallest divisor
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValidDivisor(arr, mid, threshold)) {
                right = mid; // Narrow down the range
            } else {
                left = mid + 1; // Increase the divisor
            }
        }

        return left; // The smallest valid divisor
    }

    // Helper function to find the maximum element in the list
    private static int findMax(List<Integer> arr) {
        int max = arr.get(0);
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Helper function to check if the divisor produces a sum <= threshold
    private static boolean isValidDivisor(List<Integer> arr, int divisor, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil(num / divisor)
            if (sum > threshold) {
                return false; // If sum exceeds threshold, return false
            }
        }
        return sum <= threshold; // Check if sum is within threshold
    }

    // Main method to test the minimumDivisor function
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 4, 5);
        int threshold = 10;
        int result = minimumDivisor(arr, threshold);
        System.out.println("Minimum divisor to keep sum within threshold: " + result);
    }
}

