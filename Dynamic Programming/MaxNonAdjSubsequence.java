public class MaxNonAdjSubsequence {
    static int recursion(int i,int arr[], int n) {
        if(i>=n) {
            return 0;
        }

        if(i==n-1) {
            return arr[i];
        }

        int tempSum = Math.max(arr[i]+recursion(i+2,arr,n), recursion(i+1, arr, n));
        return tempSum;
    }

    static int topDown(int i,int n,int dp[], int arr[]) {
        if(i<0) {
            return 0;
        }

        if(dp[i]!=0) {
            return dp[i];
        }

        int pick = arr[i] + topDown(i-2, n, dp, arr);
        int skip = topDown(i-1, n, dp, arr);

        dp[i] = Math.max(pick, skip);

        return dp[i];
    }

    static int bottomUp(int n,int arr[]) {
        int dp[] = new int[n];
        dp[0] = arr[0];

        for(int i=1;i<n;i++) {
            int x=0;
            int y=0;
            if(i-1>=0) {
                x = dp[i-1];
            }
            if(i-2>=0) {
                y = dp[i-2];
            }

            dp[i] = Math.max(x,y+arr[i]);
        }

        return dp[n-1];
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 10, 7};
        int n = nums.length;
        System.out.println(recursion(0, nums, n));
        int dp[] = new int[n];
        System.out.println(topDown(n-1, n, dp, nums));
        System.out.println(bottomUp(n, nums));
    }
}
