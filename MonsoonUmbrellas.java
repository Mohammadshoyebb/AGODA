/*
Question:
Umbrellas are available in different sizes that are each able to shelter a certain number of people. 
Given the number of people needing shelter and a list of umbrella sizes, determine the minimum number 
of umbrellas necessary to cover exactly the number of people given and no more. 
If there is no combination of umbrellas of the same or different sizes that covers exactly that number of people, return -1.

Function Signature:
public static int getUmbrellas(int requirement, List<Integer> sizes)

Parameters:
- int requirement: the number of people to shelter
- List<Integer> sizes: an array of umbrella sizes available

Returns:
- int: the minimum number of umbrellas required to cover exactly the requirement number of people, or -1 if it is impossible

Examples:
Example 1:
requirement = 5
sizes = [3, 5]
Output: 1
Explanation: One umbrella of size 5 can cover exactly 5 people.

Example 2:
requirement = 8
sizes = [3, 5]
Output: 2
Explanation: It is possible to use one umbrella of size 3 and one umbrella of size 5 to cover exactly 8 people.

Example 3:
requirement = 7
sizes = [3, 5]
Output: -1
Explanation: There is no combination of umbrellas that cover exactly 7 people.
*/

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MonsoonUmbrellas {

    public static int getUmbrellas(int requirement, List<Integer> sizes) {
        int[] dp = new int[requirement + 1];
        Arrays.fill(dp, requirement + 1);
        dp[0] = 0;

        for (int size : sizes) {
            for (int i = size; i <= requirement; i++) {
                dp[i] = Math.min(dp[i], dp[i - size] + 1);
            }
        }

        return dp[requirement] > requirement ? -1 : dp[requirement];
    }

    public static void main(String[] args) {
        int requirement = 8;
        List<Integer> sizes = new ArrayList<>();
        sizes.add(3);
        sizes.add(5);

        int result = getUmbrellas(requirement, sizes);
        System.out.println("Minimum umbrellas needed: " + result);

        requirement = 7;
        sizes = new ArrayList<>();
        sizes.add(3);
        sizes.add(5);

        result = getUmbrellas(requirement, sizes);
        System.out.println("Minimum umbrellas needed: " + result);

        requirement = 5;
        sizes = new ArrayList<>();
        sizes.add(3);
        sizes.add(5);

        result = getUmbrellas(requirement, sizes);
        System.out.println("Minimum umbrellas needed: " + result);
    }
}