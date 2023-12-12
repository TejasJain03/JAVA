// import java.util.Scanner;

// class Dijkstra {
//   int d[] = new int[10];
//   int p[] = new int[10];
//   int visited[] = new int[10];

//   public void dijk(int[][] a, int s, int n) {
//     int u = -1, v, i, j, min;
//     for (v = 0; v < n; v++) {
//       d[v] = 99;
//       p[v] = -1;
//     }
//     d[s] = 0;
//     for (i = 0; i < n; i++) {
//       min = 99;
//       for (j = 0; j < n; j++) {
//         if (visited[j] == 0 && d[j] < min) {
//           min = d[j];
//           u = j;
//         }
//       }

//       visited[u] = 1;
//       for (v = 0; v < n; v++) {
//         if (visited[v] == 0 && (d[u] + a[u][v] < d[v])) {
//           d[v] = d[u] + a[u][v];
//           p[v] = u;
//         }
//       }
//     }
//   }

//   public void path(int v, int s) {
//     if (p[v] != -1) {
//       path(p[v], s);
//     }
//     if (v != s) {
//       System.out.print("-> " + v + " ");
//     }
//   }

//   public void display(int s, int n) {
//     int i;
//     for (i = 0; i < n; i++) {
//       if (i != s) {
//         System.out.print(s + " ");
//         path(i, s);
//         System.out.print("= " + d[i] + " ");
//         System.out.println();
//       }
//     }
//   }

//   public static void main(String[] args) {
//     int a[][] = new int[10][10];
//     int i, j, n, s;
//     System.out.println("Enter the number of vertices:");
//     Scanner sc = new Scanner(System.in);
//     n = sc.nextInt();
//     System.out.println("Enter the weighted matrix");
//     for (i = 0; i < n; i++) {
//       for (j = 0; j < n; j++) {
//         a[i][j] = sc.nextInt();
//       }
//     }
//     System.out.println("Enter source vertex:");
//     s = sc.nextInt();
//     Dijkstra tr = new Dijkstra();
//     tr.dijk(a, s, n);
//     System.out.println(
//       "The shortest path between source" + s + " to remaining vertices are"
//     );
//     tr.display(s, n);
//   }
// }

import java.util.Scanner;

class Dijkstra {
  int d[] = new int[10];
  int p[] = new int[10];
  private String[] placeNames = {
    "Mangalore",
    "Udupi",
    "Manipal",
    "Moodbidri",
    "Karkala",
    "Surathkal",
  };
  int visited[] = new int[10];

  public void dijk(int[][] a, int source, int destination, int n) {
    int u = -1, v, i, j, min;
    for (v = 0; v < n; v++) {
      d[v] = (v == source) ? 0 : Integer.MAX_VALUE;
      p[v] = -1;
    }
    for (i = 0; i < n; i++) {
      min = Integer.MAX_VALUE;
      for (j = 0; j < n; j++) {
        if (visited[j] == 0 && d[j] < min) {
          min = d[j];
          u = j;
        }
      }

      visited[u] = 1;
      for (v = 0; v < n; v++) {
        if (visited[v] == 0 && (d[u] + a[u][v] < d[v])) {
          d[v] = d[u] + a[u][v];
          p[v] = u;
        }
      }
    }
  }

  public void path(int v, int source) {
    if (p[v] != -1) {
      path(p[v], source);
    }
    if (v != source) {
      System.out.print("-> " + placeNames[v] + " ");
    }
  }

  public void display(int source, int destination, int n) {
    if (d[destination] == Integer.MAX_VALUE) {
      System.out.println(
        "No path exists between " +
        placeNames[source] +
        " and " +
        placeNames[destination]
      );
      return;
    }

    System.out.print(
      "Shortest path from " +
      placeNames[source] +
      " to " +
      placeNames[destination] +
      ": " +
      placeNames[source] +
      " "
    );
    path(destination, source);
    System.out.println("= " + d[destination]);
  }

  public static void main(String[] args) {
    int a[][] = new int[10][10];
    int i, j, n, source, destination;
    System.out.println("Enter the number of vertices:");
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    System.out.println("Enter the weighted matrix");
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        a[i][j] = sc.nextInt();
      }
    }
    System.out.println("Enter source vertex:");
    source = sc.nextInt();
    System.out.println("Enter destination vertex:");
    destination = sc.nextInt();
    Dijkstra tr = new Dijkstra();
    tr.dijk(a, source, destination, n);
    tr.display(source, destination, n);
  }
}
