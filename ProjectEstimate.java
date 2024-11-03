// 1. Project Estimates
// A number of bids are received for a project. Determine the number of distinct pairs of project costs 
// where their absolute difference is some target value. Two pairs are distinct if they differ in at least 
// one value.
// Example:
// n = 3
// projectCosts = [1, 3, 5]
// target = 2
// There are 2 pairs: [1, 3] and [3, 5] with the target difference = 2. Therefore, 2 is returned.
// Function Description:
// Complete the function countPairs in the editor below.
// countPairs has the following parameters:
// int projectCosts[n]: array of integers
// int target: the target difference
// Return:
// int: the number of distinct pairs in projectCosts with an absolute difference of target
// Constraints:
// - 5 ≤ n ≤ 10^5
// - 0 ≤ projectCosts[i] ≤ 2 x 10^9
// - Each projectCosts[i] is distinct, i.e., unique within projectCosts
// - 1 ≤ target ≤ 10^9

// 2. Minimum Divisor
// Given an array of integers, each element is to be divided by an integer so that the sum of the results is less than 
// or equal to a threshold integer. Each non-integer result of division is rounded up before it is added to the sum.
// For example, 1/9 = 0.111..., rounded up to 1.
// Determine the minimum divisor to make the sum less than or equal to the threshold.
// Example:
// arr = [1, 5, 7]
// threshold = 8
// If the divisor is 1, the results are [1, 5, 7] which sums to 13, which is greater than the threshold 8.
// If the divisor is 2, the results are [1, 3, 4] which sums to 8, which is equal to the threshold 8.
// The minimum divisor to make the sum less than or equal to the threshold is 2.
// Function Description:
// Complete the function minimumDivisor in the editor below.
// minimumDivisor has the following parameters:
// int arr[]: an array of integers
// int threshold: the maximum value of the sum
// Returns:
// int: the minimum divisor
// Constraints:
// - 1 ≤ n ≤ 10^5
// - 1 ≤ threshold ≤ 10^9
// - 1 ≤ arr[i] ≤ 10^6

import java.util.*;

public class ProjectEstimate {

    // Function to count the number of distinct pairs with an absolute difference of target
    public static int countPairs(List<Integer> projectCosts, int target) {
        Collections.sort(projectCosts);
        int left = 0;
        int right = 1;
        int count = 0;

        while (right < projectCosts.size()) {
            int diff = projectCosts.get(right) - projectCosts.get(left);
            
            if (diff == target) {
                count++;
                left++;
                right++;
            } else if (diff < target) {
                right++;
            } else {
                left++;
            }
            
            // Ensure both pointers do not point to the same index
            if (left == right) {
                right++;
            }
        }

        return count;
    }

    // Function to find the minimum divisor to keep the sum of division results <= threshold
    public static int minimumDivisor(List<Integer> arr, int threshold) {
        int left = 1;
        int right = findMax(arr);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValidDivisor(arr, mid, threshold)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
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
                return false;
            }
        }
        return sum <= threshold;
    }

    // Main method to test both functions
    public static void main(String[] args) {
        // Test for countPairs function
        List<Integer> projectCosts = Arrays.asList(1, 3, 5);
        int target = 2;
        int result1 = countPairs(projectCosts, target);
        System.out.println("Number of distinct pairs with target difference: " + result1);

        // Test for minimumDivisor function
        List<Integer> arr = Arrays.asList(2, 4, 5);
        int threshold = 10;
        int result2 = minimumDivisor(arr, threshold);
        System.out.println("Minimum divisor to keep sum within threshold: " + result2);
    }
}

