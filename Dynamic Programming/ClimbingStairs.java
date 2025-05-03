public class ClimbingStairs {
    static int recursion(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        return recursion(n-1) + recursion(n-2);
    }
    static int bottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    static int topDown(int n,int dp[]) {
        if(n==0 || n==1) {
            return 1;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        dp[n] = topDown(n-1, dp) + topDown(n-2, dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(recursion(n));
        int dp[] = new int[n+1];
        System.out.println(topDown(n, dp));
        System.out.println(bottomUp(n));
    }
}
