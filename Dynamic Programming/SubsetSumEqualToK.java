public class SubsetSumEqualToK {
    public static boolean recursion(int a[], int target, int i) {
        if(target==0) {
            return true;
        }
        if(i==-1) {
            return false;
        }

        boolean y = false;
        if(target>=a[i]) {
            y = recursion(a, target-a[i], i-1);
        }
        boolean x = recursion(a, target, i-1);

        return x || y;

    }

    public static boolean topDown(int a[],int dp[][],int i,int target) {
        if(target==0) {
            return true;
        }
        if(i==-1) {
            return false;
        }

        if(dp[i][target]!=-1) {
            return dp[i][target]==1?true:false;
        }

        boolean x = topDown(a,dp,i-1,target);
        boolean y = false;
        if(target>=a[i]) {
            y = topDown(a, dp, i-1, target-a[i]);
        }

        dp[i][target] = x||y?1:0;

        return x||y;
    }

    public static boolean bottomUp(int a[],int target) {
        int n = a.length;
        boolean dp[][] = new boolean[n][target+1];

        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }
        dp[0][a[0]] = true;
        for(int i=1;i<n;i++) {
            for(int j=0;j<=target;j++) {
                dp[i][j] = false;
                if(j>=a[i]) {
                    dp[i][j] = dp[i-1][j-a[i]];
                }
                dp[i][j] = dp[i][j] || dp[i-1][j];
            }
        }

        return dp[n-1][target];
    }
    public static void main(String[] args) {
        
        int []arr = {2, 3, 7, 8, 10};
        int k = 11;
        System.out.println(recursion(arr, k, arr.length-1));
        int dp[][] = new int[arr.length][k+1];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<=k;j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(topDown(arr, dp, arr.length-1, k));
        System.out.println(bottomUp(arr, k));
    }
}
