import java.util.*;
public class CoinChangeWays {
    public static int recursion(int i,int coins[],int target) {
        if(i==-1) {
            return 0;
        }
        if(target==0) {
            return 1;
        }
        int take=0;
        if(target>=coins[i]) {
            take = recursion(i, coins, target-coins[i]);
        }
        int notTake = recursion(i-1, coins, target);
        return take + notTake;
    }

    public static int topDown(int i,int coins[],int target,int dp[][]) {
        if(target==0) {
            return 1;
        }
        if(i==-1) {
            return 0;
        } 
        if(dp[i][target]!=-1) {
            return dp[i][target];
        }
        int take=0;
        if(target>=coins[i]) {
            take = topDown(i, coins, target-coins[i], dp);
        }
        int notTake = topDown(i-1, coins, target, dp);
        return take + notTake;
    }

    public static int bottomUp(int n,int coins[],int target) {
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++) {
            dp[i][0]=1;
        }
        for(int i=0;i<=target;i++) {
            if(i%coins[0]==0) {
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<n;i++) {
            for(int j=0;j<=target;j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=coins[i]) {
                    dp[i][j] += dp[i][j-coins[i]];
                }
            }
        }

        return dp[n-1][target];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;
        int n = coins.length;
        System.out.println(recursion(n-1, coins, target));
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(topDown(n-1, coins, target, dp));
        System.out.println(bottomUp(n, coins, target));
    }
}