import java.util.Arrays;

public class KnapSack {
    public static int recursion(int weight,int val[],int i,int weights[]) {
        if(weight==0) {
            return 0;
        }
        if(i==-1) {
            return Integer.MIN_VALUE;
        }
        int take = 0;
        if(weight>=weights[i]){
            take = recursion(weight-weights[i], val, i-1, weights) + val[i];
        }
        int notTake = recursion(weight, val, i-1, weights);
        return Math.max(take, notTake);
    }

    public static int topDown(int weight,int val[],int i,int weights[],int dp[][]) {
        if(weight==0) {
            return 0;
        }
        if(i==-1) {
            return Integer.MIN_VALUE;
        }
        if(dp[i][weight]!=-1) {
            return dp[i][weight];
        }
        int take = 0;
        if(weight>=weights[i]){
            take = topDown(weight-weights[i], val, i-1, weights, dp) + val[i];
        }
        int notTake = topDown(weight, val, i-1, weights, dp);
        dp[i][weight] = Math.max(take, notTake);
        return dp[i][weight];
    }

    public static int bottomUp(int weight,int val[], int weights[],int n) {
        int dp[][] = new int[n][weight+1];
        for(int i=0;i<=weight;i++) {
            if(weights[0]<=i) {
                dp[0][i] = val[0];
            }
        }
        for(int i=1;i<n;i++) {
            for(int j=0;j<=weight;j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=weights[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weights[i]]+val[i]);
                }
            }
        }

        return dp[n-1][weight];
    }
    public static void main(String[] args) {
        int weights[] = {1, 3, 4, 5};

        int values[] = {1, 4, 5, 7};

        int capacity = 7;
        int n = weights.length;

        System.out.println(recursion(capacity, values, n-1, weights));
        System.out.println(bottomUp(capacity, values, weights, n));
        int dp[][] =  new int[n][capacity+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],-1);
        }
        System.out.println(topDown(capacity, values, n-1, weights, dp));
    }
}
