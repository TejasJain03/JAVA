import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

  void sort(int a[], int n) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i <= n - 2; i++) {
      int j = i;
      for (int k = i + 1; k <= n - 1; k++) {
        if (a[k] < a[j]) j = k;
      }
      int t = a[i];
      a[i] = a[j];
      a[j] = t;
    }
    long stopTime = System.currentTimeMillis();
    long elapseTime = (stopTime - startTime);
    System.out.println("Time taken to sort array is: " + elapseTime + " ms");
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int i, n;
    SelectionSort s = new SelectionSort();
    System.out.println("Enter no.of elements:");
    n = scan.nextInt();
    int a[] = new int[n];
    Random generator = new Random();
    for (i = 0; i < n; i++) a[i] = generator.nextInt(100);
    s.sort(a, n);
  }
}
