public class GridUniquePaths {
    public static int recursion(int i,int j,int m,int n) {
        if(i==m-1 && j==n-1) {
            return 1;
        }
        if(i>=m || j>=n) {
            return 0;
        }

        int x = recursion(i+1, j, m, n);
        int y = recursion(i, j+1, m, n);
        return x+y;
    }

    public static int topDown(int i,int j,int dp[][],int m,int n) {
        if(i==0 && j==0) {
            return 1;
        }
        if(i<0 || j<0) {
            return 0;
        }
        if(dp[i][j]!=0) {
            return dp[i][j];
        }
        int x = topDown(i-1, j, dp, m, n);
        int y = topDown(i,j-1,dp,m,n);
        dp[i][j] = x+y;
        return dp[i][j];
    }

    public static int bottomUp(int m,int n) {
        int dp[][] = new int[m][n];
        dp[0][0] =1;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i-1>=0) {
                    dp[i][j] = dp[i-1][j];
                }
                if(j-1>=0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        System.out.println(recursion(0,0,m,n));
        int dp[][] =  new int[m][n];
        System.out.println(topDown(m-1,n-1, dp, m, n));
        System.out.println(bottomUp(m, n));
    }
}
