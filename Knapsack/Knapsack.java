import java.util.Scanner;

public class Knapsack {
  private static void knapsack(int n, double w[], double p[], int m) {
    double x[] = new double[n];
    double profit = 0;
    int i;
    for (i = 0; i < n; i++) {
      x[i] = 0;
      if (w[i] > m) {
        break;
      }
      x[i] = 1;
      profit = profit + p[i];
      m = m - (int) w[i];
    }
    if (i < n) {
      x[i] = (double) m / w[i];
      profit = profit + (x[i] * p[i]);
    }

    System.out.println("Selected items:");
    for (i = 0; i < n; i++) {
      System.out.println(x[i]);
    }
    System.out.println("Profit:" + profit);
  }

  // private static void swap(double a,double b){
  //   double temp=a;
  //   a=b;
  //   b=temp;
  // }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, i, j, k, m;
    System.out.println("Enter the number of elements:");
    n = sc.nextInt();
    System.out.println("Enter the capacity of the bag:");
    m = sc.nextInt();
    if(m<=0){
      System.out.println("Invalid Capacity");
      System.exit(0);
    }
    double[] profit = new double[n];
    double[] weight = new double[n];
    double[] ratio = new double[n];
    System.out.println("Enter the Profit:");
    for (i = 0; i < n; i++) {
      profit[i] = sc.nextDouble();
    }
    System.out.println("Enter the Weight:");
    for (i = 0; i < n; i++) {
      weight[i] = sc.nextDouble();
    }
    for (i = 0; i < n; i++) {
      ratio[i] = profit[i] / weight[i];
    }

    for (i = 0; i < n - 1; i++) {
      j = i;
      for (k = i + 1; k < n; k++) {
        if (ratio[k] > ratio[j]) j = k;
      }
      double t=ratio[i];
      ratio[i]=ratio[j];
      ratio[j]=t;
      double t1 = profit[i];
      profit[i] = profit[j];
      profit[j] = t1;
      double t2 = weight[i];
      weight[i] = weight[j];
      weight[j] = t2;
    }
    // for (i = 0; i < n; i++) {
    //   System.out.println(ratio[i]);
    // }
    knapsack(n, weight, profit, m);

  }
}
