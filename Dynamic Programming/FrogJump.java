public class FrogJump {
    public static int recursion(int i,int n,int energy[]) {
        if(i==0) {
            return 0;
        }

        if(i==1) {
            return Math.abs(energy[1] - energy[0]);
        }

        return Math.min(recursion(i-1, n, energy)+Math.abs(energy[i]-energy[i-1])
                        ,recursion(i-2, n, energy)+Math.abs(energy[i]-energy[i-2]));
    }
    public static int topDown(int i,int n,int energy[], int dp[]) {
        if(i==0) {
            return 0;
        }

        if(i==1) {
            return Math.abs(energy[1] - energy[0]);
        }

        if(dp[i]!=0) {
            return dp[i];
        }

        dp[i] = Math.min(Math.abs(energy[i]-energy[i-1]) + topDown(i-1, n, energy, dp), Math.abs(energy[i]-energy[i-2]) + topDown(i-2, n, energy, dp));
        return dp[i];
    }

    static int bottomUp(int n,int energy[]) {
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = Math.abs(energy[1] - energy[0]);

        for(int i=2;i<=n;i++) {
            dp[i] = Math.min(dp[i-1]+Math.abs(energy[i]-energy[i-1]), dp[i-2] + Math.abs(energy[i] - energy[i-2]));
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int[] energy = {30, 10, 60, 10, 60, 50};
        int n = energy.length;
        System.out.println(recursion(n-1,n,energy));
        int dp[] = new int[n+1];
        System.out.println(topDown(n-1, n, energy, dp));
        System.out.println(bottomUp(n-1, energy));

    }
}
