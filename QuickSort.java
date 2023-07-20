import java.util.Random;
import java.util.Scanner;

public class QuickSort {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    System.out.println("Enter the size of array:");
    int size = sc.nextInt();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = r.nextInt(200);
    }
    System.out.println("Before Sorting:");
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i] + " ");
    }
    long startTime = System.currentTimeMillis();
    quickSort(arr, 0, size - 1);
    long stopTime = System.currentTimeMillis();
    System.out.println();
    System.out.println("After Sorting:");
    for (int i = 0; i < size; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    System.out.println("Time taken:"+(stopTime-startTime)+"ms");
  }

  private static void quickSort(int[] arr, int start, int end) {
    if (end <= start) return;

    int pivot = partition(arr, start, end);
    quickSort(arr, start, pivot - 1);
    quickSort(arr, pivot + 1, end);
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;

    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    i++;
    int temp = arr[i];
    arr[i] = arr[end];
    arr[end] = temp;

    return i;
  }
}
