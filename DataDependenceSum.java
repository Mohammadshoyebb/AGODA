// Data analysts at Amazon are analyzing time-series data. It was concluded that the data of the nth item
// was dependent on the data of some xh day if there is a positive integer k such that floor(n/k) = x.
// Given n, find the sum of all day numbers on which the data of the x (0 <= x <= n) will be dependent.
//
// For each x, we find k values that satisfy the condition and then compute the sum of unique x values
// obtained from valid k ranges.

import java.util.HashSet;

public class DataDependenceSum {
    
    // Function to calculate the sum of dependent days
    public static long getDataDependenceSum(long n) {
        HashSet<Long> dependentDays = new HashSet<>();
        
        long k = 1;
        while (k <= n) {
            // Calculate v, which is floor(n/k)
            long v = n / k;

            // If v is zero, we can stop since higher k will only produce zero
            if (v == 0) {
                break;
            }

            // Add v to the set of dependent days
            dependentDays.add(v);

            // Move k to the next possible k value that results in the same v
            long maxK = n / v;

            // Move to the next k beyond the current maxK
            k = maxK + 1;
        }

        // Sum up all unique dependent days
        long sum = 0;
        for (long day : dependentDays) {
            sum += day;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        // Sample test cases
        System.out.println(getDataDependenceSum(13));  // Output: 29
        System.out.println(getDataDependenceSum(1));   // Output: 1
        System.out.println(getDataDependenceSum(100));  // Output for larger n
        System.out.println(getDataDependenceSum(10000000000L));  // Test for maximum n
    }
}
