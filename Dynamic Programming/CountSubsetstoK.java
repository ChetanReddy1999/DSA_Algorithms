import java.util.*;

public class CountSubsetstoK {
    public static int recursion(int a[],int i,int target) {
        if(target==0) {
            return 1;
        }
        if(i==-1) {
            return 0;
        }

        int x = recursion(a, i-1, target);
        int y=0;
        if(target>=a[i]) {
            y = recursion(a, i-1, target-a[i]);
        }

        return x+y;
    }

    public static int topDown(int a[],int i,int target, int dp[][]) {
        if(target==0) {
            return 1;
        }
        if(i==-1) {
            return 0;
        }

        if(dp[i][target]!=-1) {
            return dp[i][target];
        }

        int x = topDown(a, i-1, target, dp);
        int y=0;
        if(target>=a[i]) {
            y = topDown(a, i-1, target-a[i], dp);
        }
        dp[i][target] = x+y;
        return x+y;
    }

    public static int bottomUp(int a[],int n, int target) {
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        if(target>=a[0]) {
            dp[0][a[0]] = 1;
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<=target;j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=a[i]) {
                    dp[i][j] += dp[i-1][j-a[i]];
                }
            }
        }

        return dp[n-1][target];
    } 
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;
        int n = arr.length;
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }

        System.out.println(recursion(arr, n-1, target));
        System.out.println(topDown(arr, n-1, target, dp));
        System.out.println(bottomUp(arr, n, target));
    }
}
