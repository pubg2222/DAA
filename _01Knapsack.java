import java.lang.Math;
import java.util.Scanner;
class _01Knapsack{
    private static void printObjectIncluded(int[][]dp, int[] weight, int i, int j){
        while(i>0 && j>0){
            if(dp[i][j] == dp[i-1][j]){
                System.out.println("Object "+ i + " = Not Included");
                i--;
            }else{
                System.out.println("Object "+ i + " = Included");
                j = j-weight[i];
                i--;
            }
        }
        while(i>0){
            System.out.println("Object "+ i + " = Not Included");
            i--;
        }
    }

    private static void Knapsack(int[] weight, int[] profit, int n, int w, int[][]dp) {
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(weight[i]<=j) dp[i][j] = Math.max(profit[i]+dp[i-1][j-weight[i]], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println("Maximum profit is : "+dp[n][w]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of objects : ");
        int n = sc.nextInt();
        System.out.println();

        System.out.print("Enter weight of knapsack : ");
        int w = sc.nextInt();
        System.out.println();

        int[] profit = new int[n+1];
        int[] weight = new int[n+1];
        for(int i=1; i<=n; i++){
            System.out.println("Enter weight and profit of object no. " +i+" : ");
            weight[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }
        sc.close();
        int[][] dp = new int[n+1][w+1];
        System.out.println("-----------------------------------------------------------------------");
        Knapsack(weight, profit, n, w, dp);
        System.out.println("-----------------------------------------------------------------------");
        printObjectIncluded(dp, weight, n, w);
        System.out.println("-----------------------------------------------------------------------");
    }
}