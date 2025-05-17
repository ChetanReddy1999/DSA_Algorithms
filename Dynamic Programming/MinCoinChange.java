public class MinCoinChange {
    public static int recursion(int coins[], int target, int i) {
        if(target==0) {
            return 0;
        }
        if(i==-1) {
            return Integer.MAX_VALUE;
        }
        int notTake = recursion(coins, target, i-1);
        int take = Integer.MAX_VALUE;
        if(target >= coins[i]){
            take = recursion(coins, target - coins[i], i);
            if(take!=Integer.MAX_VALUE) {
                take += 1;
            }
        }

        return Math.min(notTake, take);
    }

    public static int topDown(int i,int coins[],int target, int dp[][]) {
        if(target==0) {
            return 0;
        }
        if(i==-1) {
            return (int)(1e9);
        }
        if(dp[i][target]!=0) {
            return dp[i][target];
        }
        int notTake = topDown(i-1, coins, target, dp);
        int take = (int)(1e9);
        if(target >= coins[i]){
            take = topDown(i, coins, target-coins[i], dp)+1;
        }
        dp[i][target] = Math.min(take, notTake);
        return dp[i][target];
    }

    public static int bottomUp(int coins[],int n, int target) {
        int dp[][] = new int[n][target+1];

        for(int i=1;i<=target;i++) {
            if(i%coins[0]==0) {
                dp[0][i] = i/coins[0];
            }
            else{
                dp[0][i] = (int)(1e9);
            }
        }
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<=target;j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=coins[i]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]]+1);
                }
            }
        }

        return dp[n-1][target];
        
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        int n = coins.length;
        System.out.println(recursion(coins, target, n-1));
        int dp[][] = new int[n][target+1];
        System.out.println(topDown(n-1, coins, target, dp));
        System.out.println(bottomUp(coins, n, target));
    }
}
