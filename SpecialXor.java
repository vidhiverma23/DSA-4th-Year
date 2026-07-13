import java.util.*;

public class SpecialXor {

    static class Solution {

        public List<Integer> specialXor(
                int N, int Q, int[] a, int[][] query) {

            List<Integer> result = new ArrayList<>();

            // Prefix XOR
            int[] prefix = new int[N + 1];

            for (int i = 0; i < N; i++) {
                prefix[i + 1] = prefix[i] ^ a[i];
            }

            // XOR of the entire array
            int totalXor = prefix[N];

            // Process each query
            for (int i = 0; i < Q; i++) {

                int L = query[i][0];
                int R = query[i][1];

                // XOR of elements from L to R (1-based indexing)
                int rangeXor = prefix[R] ^ prefix[L - 1];

                // XOR of all elements excluding [L, R]
                int answer = totalXor ^ rangeXor;

                result.add(answer);
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input N and Q
        int N = sc.nextInt();
        int Q = sc.nextInt();

        // Input array
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        // Input queries
        int[][] query = new int[Q][2];

        for (int i = 0; i < Q; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
        }

        // Create Solution object
        Solution solution = new Solution();

        // Get results
        List<Integer> result =
                solution.specialXor(N, Q, a, query);

        // Print answers
        for (int answer : result) {
            System.out.println(answer);
        }

        sc.close();
    }
}