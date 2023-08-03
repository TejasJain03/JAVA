import java.util.Scanner;

public class Prims {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n, i, j, s, k = 0;
    int w[][] = new int[10][10];
    int min, sum = 0, u = 0, v = 0, flag = 0;
    System.out.println("Enter the number of the vertices:");
    n = sc.nextInt();
    int sol[] = new int[n];
    for (i = 0; i < n; i++) {
      sol[i] = 0;
    }
    System.out.println("Enter the weights of graph:");
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        w[i][j] = sc.nextInt();
      }
    }
    System.out.println("Enter the source vertex:");
    s = sc.nextInt();
    sol[s] = 1;
    k = 1;

    while (k <= n - 1) {
      min = 99;
      for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
          if (sol[i] == 1 && sol[j] == 0) {
            if (i != j && min > w[i][j]) {
              min = w[i][j];
              u = i;
              v = j;
            }
          }
        }
      }
      sol[v] = 1;
      sum += min;
      System.out.println(u + "-->" + v + "=" + min);
      k++;
    }
    for (i = 0; i < n; i++) {
      if (sol[i] == 0) {
        flag = 1;
      }
    }
    if (flag == 1) {
      System.out.println("No spanning tree");
    } else {
      System.out.println("The cost of MST=" + sum);
    }
  }
}
