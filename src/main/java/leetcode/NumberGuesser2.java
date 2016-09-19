package leetcode;

/**
 * Created by Chethan on 9/18/16.
 */
//dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].
//dp[i][j] = min{k + max{dp[i][k-1]+dp[k+1][j]}} for all i<=k<=j
//https://leetcode.com/problems/guess-number-higher-or-lower-ii/
public class NumberGuesser2 {
    public int getMoneyAmount(int n) {
        if (n <= 1) return 0;
        int dp[][] = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; (i + len) <= (n+1); i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
