package ProblemSolving;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of paths for each cell
        int[][] dp = new int[m][n];

        // Initialize the first row and first column with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Update the number of paths for each cell based on the previous rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // The bottom-right cell contains the total number of unique paths
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();

        // Example usage:
        int m = 3;
        int n = 4;
        int result = solution.uniquePaths(m, n);
        System.out.println("The number of unique paths for a " + m + " x " + n + " grid is: " + result);
    }
}
