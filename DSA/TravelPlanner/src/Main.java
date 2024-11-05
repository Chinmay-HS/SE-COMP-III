import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        // Add Cities
        System.out.println("Enter the number of cities:");
        int cityCount = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < cityCount; i++) {
            System.out.println("Enter the name of city " + (i + 1) + ":");
            String cityName = scanner.nextLine();
            City city = new City(cityName);
            graph.addCity(city);
        }

        // Add Roads
        System.out.println("Enter the number of roads:");
        int roadCount = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < roadCount; i++) {
            System.out.println("Enter the starting city for road " + (i + 1) + ":");
            City startCity = new City(scanner.nextLine());

            System.out.println("Enter the destination city for road " + (i + 1) + ":");
            City endCity = new City(scanner.nextLine());

            System.out.println("Enter the distance between " + startCity.getName() + " and " + endCity.getName() + " (in km):");
            int distance = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.println("Select the transport mode (CAR, BUS, TRAIN, FLIGHT):");
            String mode = scanner.nextLine().toUpperCase();
            TransportMode transportMode = TransportMode.valueOf(mode);

            System.out.println("Enter the traffic multiplier (1 for normal, 2 for heavy traffic):");
            int trafficMultiplier = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            graph.addRoad(startCity, endCity, distance, transportMode, trafficMultiplier);
        }

        // Show Graph
        graph.printGraph();

        // Find Shortest Path
        System.out.println("Enter the starting city for finding the shortest path:");
        City startCity = new City(scanner.nextLine());

        System.out.println("Enter the destination city for finding the shortest path:");
        City endCity = new City(scanner.nextLine());

        graph.findShortestPath(startCity, endCity);
    }
}
