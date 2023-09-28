public class FlightTicketCost {
    public static int findMinCost(int[] A) {
        int N = A.length;
        int[] dp = new int[N];

        // Initialize the first city (city 1)
        dp[0] = 0;

        // Calculate minimum cost for each city starting from city 2
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;

            // Check if there is a direct flight to the next city (i+1)
            if (i - 1 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + Math.abs(A[i] - A[i - 1]));
            }

            // Check if there is a flight to the city after the next city (i+3)
            if (i - 3 >= 0) {
                dp[i] = Math.min(dp[i], dp[i - 3] + Math.abs(A[i] - A[i - 3]));
            }
        }

        // The minimum cost to reach the last city (city N) is the answer
        return dp[N - 1];
    }

    public static void main(String[] args) {
        int[] A = {4,12,13,18,10,12};
        int minCost = findMinCost(A);
        System.out.println("Minimum Cost of Flight Ticket: " + minCost );
    }
}