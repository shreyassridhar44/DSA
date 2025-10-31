// FizzBuzz Problem

import java.util.*;

public class FizzBuzz {

    // Optimal Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1) (excluding output list)
    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                answer.add("FizzBuzz");
            else if (i % 3 == 0)
                answer.add("Fizz");
            else if (i % 5 == 0)
                answer.add("Buzz");
            else
                answer.add(Integer.toString(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<String> result = fizzBuzz(n);
        System.out.println(result);
    }
}
