import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FileHandling {
  static ArrayList<String> placeNames = new ArrayList<>(
    Arrays.asList(
      "Mangalore",
      "Udupi",
      "Manipal",
      "Moodbidri",
      "Karkala",
      "Surathkal",
      "Kasargod",
      "Beltangady",
      "Kateel",
      "Bantwal",
      "Puttur",
      "Sullia"
    )
  );

  int[][] a = {
    { 999, 42, 78, 4, 71, 57, 11, 3, 47, 99, 31, 53 },
    { 3, 999, 65, 50, 26, 88, 44, 71, 12, 89, 63, 95 },
    { 98, 67, 999, 87, 48, 37, 80, 76, 82, 95, 84, 1 },
    { 47, 56, 19, 999, 93, 19, 3, 98, 57, 6, 20, 27 },
    { 63, 12, 74, 41, 999, 65, 85, 50, 17, 48, 1, 58 },
    { 17, 26, 75, 66, 97, 999, 9, 76, 24, 50, 31, 42 },
    { 50, 90, 62, 78, 81, 72, 999, 43, 67, 17, 76, 29 },
    { 37, 10, 66, 1, 16, 90, 47, 999, 22, 63, 76, 72 },
    { 7, 81, 64, 91, 89, 44, 61, 37, 999, 45, 98, 1 },
    { 3, 47, 35, 93, 36, 59, 18, 92, 51, 999, 64, 9 },
    { 84, 12, 95, 51, 10, 29, 74, 82, 66, 98, 999, 57 },
    { 77, 19, 25, 90, 67, 17, 36, 26, 31, 33, 79, 999 },
  };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String filePath = "parcels.csv";
    System.out.println("1.Add Parcel \n 2. Find parcel\n 3.Update parcel");
    int option = sc.nextInt();
    FileHandling file = new FileHandling();

    switch (option) {
      case 1:
        Random r = new Random();
        String parcelNo = Integer.toString(r.nextInt(100000, 999999));
        System.out.println("Enter Source index:");
        int source = sc.nextInt();
        System.out.println("Enter Destination index:");
        int destination = sc.nextInt();
        String status = "Shipped";

        saveParcelToFile(filePath, parcelNo, source, destination, status);
        break;
      case 2:
        file.readSourceAndDestinationForParcel(filePath);
        break;
      case 3:
        file.updateStatus(filePath);
        break;
      default:
        System.out.println("Invalid option");
        break;
    }
    // Save parcel information to the CSV file

    // Read source and destination information for a specific parcel from CSV
  }

  private static void saveParcelToFile(
    String filePath,
    String parcelNo,
    int source,
    int destination,
    String status
  ) {
    try (FileWriter writer = new FileWriter(filePath, true)) {
      writer.write(
        parcelNo +
        "," +
        placeNames.get(source) +
        "," +
        placeNames.get(destination) +
        "," +
        status +
        "," +
        placeNames.get(source) +
        "\n"
      );

      System.out.println("Parcel information has been saved to the file.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readSourceAndDestinationForParcel(String filePath) {
    try (Scanner scanner = new Scanner(new File(filePath))) {
      Scanner userInputScanner = new Scanner(System.in);

      System.out.print("Enter Parcel Number:");
      String targetParcelNo = userInputScanner.nextLine();

      boolean parcelFound = false;

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");

        if (parts.length == 5) {
          String parcelNo = parts[0];
          String source = parts[1];
          String destination = parts[2];
          String status = parts[3];
          String currentLocation = parts[4];

          if (parcelNo.equals(targetParcelNo)) {
            System.out.println("Parcel Found!");
            System.out.println("Parcel No: " + parcelNo);
            System .out.println("Source: " + source);
            System.out.println("Destination: " + destination);
            System.out.println("Status: " + status);
            System.out.println("Curent Location: " + currentLocation);

            Dijkstra tr = new Dijkstra(
              placeNames.indexOf(source),
              placeNames.indexOf(destination)
            );
            tr.dijk(
              a,
              placeNames.indexOf(source),
              placeNames.indexOf(destination),
              12
            );
            tr.display(
              placeNames.indexOf(source),
              placeNames.indexOf(destination),
              12
            );
            parcelFound = true;
            break;
          }
        }
      }

      if (!parcelFound) {
        System.out.println(
          "Parcel not found with Parcel Number: " + targetParcelNo
        );
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateStatus(String filePath) {
    try {
      // Read existing records
      Scanner scanner = new Scanner(new File(filePath));
      StringBuilder fileContent = new StringBuilder();

      Scanner userInputScanner = new Scanner(System.in);

      System.out.print("Enter Parcel Number to update status: ");
      String targetParcelNo = userInputScanner.nextLine();

      boolean recordFound = false;

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");

        // Assuming the first part is the Parcel Number
        String parcelNumber = parts[0].trim();

        if (parcelNumber.equals(targetParcelNo)) {
          // Update the status
          String source = parts[1];
          String destination = parts[2];
          Dijkstra tr = new Dijkstra(
            placeNames.indexOf(source),
            placeNames.indexOf(destination)
          );
          tr.dijk(
            a,
            placeNames.indexOf(source),
            placeNames.indexOf(destination),
            12
          );
          tr.display(
            placeNames.indexOf(source),
            placeNames.indexOf(destination),
            12
          );
          System.out.print("Update Location: Enter the city number ");
          int index = userInputScanner.nextInt();
          parts[4] = placeNames.get(index);
          System.out.println(parts[4]);
          if (placeNames.indexOf(destination) == placeNames.indexOf(parts[4])) {
            parts[3] = "Delivered";
          }
          if(placeNames.indexOf(source)!=placeNames.indexOf(parts[4]) && placeNames.indexOf(destination)!=placeNames.indexOf(parts[4])){
            parts[3]="In Transit";
          }

          recordFound = true;
        }

        fileContent.append(String.join(",", parts)).append("\n");
      }

      // Close the scanner
      scanner.close();

      // Write the modified content back to the file
      FileWriter fileWriter = new FileWriter(filePath);
      fileWriter.write(fileContent.toString());
      fileWriter.close();

      if (recordFound) {
        System.out.println("Status updated successfully.");
      } else {
        System.out.println(
          "Parcel not found with Parcel Number: " + targetParcelNo
        );
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  class Dijkstra {
    int d[] = new int[20];
    int p[] = new int[20];
    int source, destination;
    ArrayList<String> placeNames = new ArrayList<>(
      Arrays.asList(
        "Mangalore",
        "Udupi",
        "Manipal",
        "Moodbidri",
        "Karkala",
        "Surathkal",
        "Kasargod",
        "Beltangady",
        "Kateel",
        "Bantwal",
        "Puttur",
        "Sullia"
      )
    );
    int visited[] = new int[20];

    public Dijkstra(int source, int destination) {
      this.source = source;
      this.destination = destination;
    }

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
        System.out.print("-> " + v + ")" + placeNames.get(v) + " ");
      }
    }

    public void display(int source, int destination, int n) {
      System.out.print(
        "Shortest path from " +
        placeNames.get(source) +
        " to " +
        placeNames.get(destination) +
        ": " +
        source +
        ")" +
        placeNames.get(source) +
        " "
      );
      path(destination, source);
      System.out.println("= " + d[destination]);
    }
  }
}
