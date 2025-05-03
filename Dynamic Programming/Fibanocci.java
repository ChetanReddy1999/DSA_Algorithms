import java.util.*;
public class Fibanocci {
    static int recursion(int n) {
        if(n==1 || n==0) {
            return n;
        }
        return recursion(n-1) + recursion(n - 2);
    }

    static int TopDown(int n, int dp[]) {
        if(dp[n]!=-1) {
            return dp[n];
        }
        if(n==0 || n==1) {
            dp[n] = n;
            return dp[n];
        }
        dp[n] = TopDown(n-1, dp) + TopDown(n-2, dp);
        return dp[n];
    }
    static int bottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]) {
        int n = 1;
        // 0,1,1,2,3,5,8,13
        // System.out.println(recursion(n));
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(TopDown(n, dp));
        System.out.println(bottomUp(n));
    }
    
}
