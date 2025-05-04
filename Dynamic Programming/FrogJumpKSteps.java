public class FrogJumpKSteps {
    public static int recursion(int i,int n, int k,int energy[]) {
        if(i==0) {
            return 0;
        }

        if(i==1) {
            return Math.abs(energy[1] - energy[0]);
        }
        int ans = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++) {
            if(i-j<0){
                continue;
            }
            ans = Math.min(ans, Math.abs(energy[i]-energy[i-j])+recursion(i-j, ans, k, energy));
        }

        return ans;
    }
    public static int topDown(int i,int n, int k,int energy[], int dp[]) {
        if(i==0) {
            return 0;
        }

        if(i==1) {
            return Math.abs(energy[1] - energy[0]);
        }

        if(dp[i]!=0) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++) {
            if(i-j<0){
                continue;
            }
            ans = Math.min(ans, Math.abs(energy[i]-energy[i-j])+topDown(i-j, n, k, energy, dp));
        }

        dp[i] = ans;
        return dp[i];
    }

    static int bottomUp(int n, int k,int energy[]) {
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = Math.abs(energy[1] - energy[0]);
        
        
        for(int i=2;i<=n;i++) {
            int ans = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++) {
                if(i-j<0){
                    continue;
                }
                ans = Math.min(ans, Math.abs(energy[i]-energy[i-j])+dp[i-j]);
            }
            dp[i] = ans;
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int[] energy = {10, 30, 40, 50, 20};
        int n = energy.length;
        int k = 3;
        System.out.println(recursion(n-1,n,k,energy));
        int dp[] = new int[n+1];
        System.out.println(topDown(n-1, n, k, energy, dp));
        System.out.println(bottomUp(n-1,k, energy));

    }
}
