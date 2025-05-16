public class GridUniquePaths2 {
    public static int recursion(int a[][],int i,int j,int m,int n) {
        if(i==m-1 && j==n-1) {
            return 1;
        }

        if(i>=m || j>=n || a[i][j]==1) {
            return 0;
        }

        int x = recursion(a, i+1, j, m, n);
        int y= recursion(a, i, j+1, m, n);
        return x+y;
    }

    public static int topDown(int a[][],int i,int j,int m,int n,int dp[][]) {
        if(i==0 && j==0) {
            return 1;
        }

        if(i<0 || j<0 || a[i][j]==1) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int x = topDown(a, i-1, j, m, n, dp);
        int y = topDown(a, i, j-1, m, n, dp);
        dp[i][j] = x+y;
        return dp[i][j];
    }

    public static int bottomUp(int a[][],int m,int n) {
        int dp[][] = new int[m][n];
        if(a[0][0]==1){
            return 0;
        }
        dp[0][0] = 1;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(a[i][j]==1) {
                    dp[i][j] = 0;
                    continue;
                }
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
        int[][] obstacleGrid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(recursion(obstacleGrid, 0, 0, m, n));
        System.out.println(bottomUp(obstacleGrid, m, n));
        System.out.println(topDown(obstacleGrid, m-1, n-1, m, n, dp));
    }
}
