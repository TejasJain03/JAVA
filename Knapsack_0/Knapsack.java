import java.util.Scanner;

public class Knapsack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Knapsack k = new Knapsack();
        int p[] = new int[10];
        int w[] = new int[10];
        int v[][] = new int[10][10];
        int n, m, i, j;
        System.out.println("Enter the number of items:");
        n = sc.nextInt();
        System.out.println("Enter the Profits:");
        for (i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter the Weights:");
        for (i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println("Enter the capacity:");
        m = sc.nextInt();
        System.out.println("Item\tWeight\tProfit");
        for (i = 0; i < n; i++) {
            System.out.println(i + "\t" + w[i] + "\t" + p[i]);
        }
        k.result(m, n, w, p, v);
        System.out.println("The items in bag are:");
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) { // Changed this loop limit to '<='
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }
        k.optimal(m, n, w, v);
    }

    public int max(int i, int j) {
        if (i > j)
            return i;
        else
            return j;
    }

    public void result(int m, int n, int w[], int p[], int v[][]) {
        int i, j;
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else if (w[i - 1] > j) { // Changed w[i] to w[i-1]
                    v[i][j] = v[i - 1][j];
                } else {
                    v[i][j] = max(v[i - 1][j], p[i - 1] + v[i - 1][j - w[i - 1]]); // Changed w[i] to w[i-1] and p[i] to p[i-1]
                }
            }
        }
    }

    public void optimal(int m, int n, int[] w, int[][] v) {
        int[] x = new int[n];
        int i = n, j = m, item = 0;
        while (i != 0 && j != 0) {
            if (v[i][j] != v[i - 1][j]) {
                x[i - 1] = 1; // Changed x[i] to x[i-1]
                j = j - w[i - 1]; // Changed w[i] to w[i-1]
                item = 1;
            }
            i--;
        }
        System.out.println("Optimal Solution:" + v[n][m]); // Changed v[n] to v[n][m]
        System.out.println("Selected Items are:");
        for (i = 0; i < n; i++) {
            if (x[i] == 1) {
                System.out.print(i + "\t");
            }
            if (item == 0) {
                System.out.println("No items were placed in Knapsack");
            }
        }
    }
}
