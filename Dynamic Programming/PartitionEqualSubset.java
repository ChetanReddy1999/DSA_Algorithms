public class PartitionEqualSubset {
    public static boolean recursion(int i,int target,int a[]) {
        if(target==0){
            return true;
        }
        if(i==-1){
            return false;
        }
        boolean x = recursion(i-1,target,a);
        boolean y = false;
        if(target>=a[i]) {
            y = recursion(i-1, target-a[i], a);
        }

        return x || y;
    }

    public static boolean topDown(int i,int dp[][],int a[],int n,int target) {
        if(target==0) {
            return true;
        }
        if(i==-1) {
            return false;
        }
        if(dp[i][target]!=-1) {
            return dp[i][target] == 1;
        }

        boolean x = topDown(i-1, dp, a, n, target);
        boolean y = false;
        if(target>=a[i]) {
            y = topDown(i-1, dp, a, n, target-a[i]);
        }
        dp[i][target] = x||y?1:0;
        return x || y;
    }

    public static boolean bottomUp(int a[],int n,int target) {
        boolean dp[][] = new boolean[n][target+1];
        if(target>=a[0]) {
            dp[0][a[0]] = true; 
        }
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<=target;j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=a[i]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-a[i]];
                }
            }
        }

        return dp[n-1][target];
    }
    public static void main(String[] args) {
        int sum=0;
        int a[] = {13,52,423,4};
        for(int i=0;i<a.length;i++) {
            sum +=a[i];
        }
        int n_target = sum/2;
        if(n_target%2!=0) {
            System.out.println(false);
        }
        else{
            System.out.println(bottomUp(a, a.length, n_target));
        }
    }
}
