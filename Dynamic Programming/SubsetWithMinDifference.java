public class SubsetWithMinDifference {
    public static boolean[][] bottotmUp(int a[],int n) {
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum+= a[i];
        }

        boolean dp[][] = new boolean[n][sum+1];

        dp[0][a[0]] = true;
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<=sum;j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=a[i]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-a[i]];
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 11, 5};
        int n = a.length;

        int sum=0;
        for(int i=0;i<n;i++) {
            sum +=a[i];
        }

        boolean dp[][] = bottotmUp(a, n);
        int ans = Integer.MAX_VALUE;

        for(int j=0;j<=sum;j++) {
            if(dp[n-1][j]) {
                ans = Math.min(ans, Math.abs(j-(sum-j)));
            }
        }

        System.out.println(ans);
    }
}
