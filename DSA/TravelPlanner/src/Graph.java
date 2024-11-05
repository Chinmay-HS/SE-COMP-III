import java.util.*;

public class Graph {
    private Map<City, List<Road>> adjacencyList;
    private Map<String, City> cityMap;

    public Graph() {
        adjacencyList = new HashMap<>();
        cityMap = new HashMap<>();
    }

    public void addCity(City city) {
        adjacencyList.putIfAbsent(city, new ArrayList<>());
        cityMap.put(city.getName(), city);
    }

    public City getCityByName(String name) {
        return cityMap.get(name);
    }

    public void addRoad(City city1, City city2, int distance, TransportMode mode, int trafficMultiplier) {
        if (adjacencyList.get(city1) == null || adjacencyList.get(city2) == null) {
            System.out.println("One of the cities does not exist. Please add the cities first.");
            return;
        }

        Road road = new Road(city1, city2, distance, mode, trafficMultiplier);
        adjacencyList.get(city1).add(road);
        adjacencyList.get(city2).add(road);
    }

    public void printGraph() {
        System.out.println("Graph Representation:");
        for (City city : adjacencyList.keySet()) {
            System.out.print(city + " -> ");
            for (Road road : adjacencyList.get(city)) {
                System.out.print(road.getCity2() + " (Mode: " + road.getMode() + ", Distance: " + road.getDistance() + " km), ");
            }
            System.out.println();
        }
    }

    // Dijkstra's Algorithm
    public void findShortestPath(City start, City end) {
        Map<City, Integer> distances = new HashMap<>(); // Keeps track of minimum distance to each city
        Map<City, City> previous = new HashMap<>(); // For path reconstruction
        PriorityQueue<RoadEntry> queue = new PriorityQueue<>(Comparator.comparingInt(RoadEntry::getDistance));

        // Initialize distances
        for (City city : adjacencyList.keySet()) {
            distances.put(city, Integer.MAX_VALUE); // Set to infinity
            previous.put(city, null);
        }
        distances.put(start, 0); // Distance to start city is 0
        queue.add(new RoadEntry(start, 0));

        // Process the priority queue
        while (!queue.isEmpty()) {
            RoadEntry currentEntry = queue.poll();
            City currentCity = currentEntry.getCity();

            if (currentCity.equals(end)) {
                break; // Found the shortest path to the destination
            }

            // Explore neighbors
            for (Road road : adjacencyList.get(currentCity)) {
                City neighbor = road.getCity2().equals(currentCity) ? road.getCity1() : road.getCity2();
                int newDist = distances.get(currentCity) + road.getDistance();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, currentCity);
                    queue.add(new RoadEntry(neighbor, newDist));
                }
            }
        }

        // Reconstruct and print the shortest path
        if (distances.get(end) == Integer.MAX_VALUE) {
            System.out.println("No path found from " + start.getName() + " to " + end.getName());
        } else {
            List<City> path = new ArrayList<>();
            for (City at = end; at != null; at = previous.get(at)) {
                path.add(at);
            }
            Collections.reverse(path);
            System.out.println("Shortest path from " + start.getName() + " to " + end.getName() + ":");
            for (City city : path) {
                System.out.print(city.getName() + " ");
            }
            System.out.println("\nTotal travel distance: " + distances.get(end) + " km");
        }
    }

    // Helper class to store city and distance in the priority queue
    private class RoadEntry {
        private City city;
        private int distance;

        public RoadEntry(City city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        public City getCity() {
            return city;
        }

        public int getDistance() {
            return distance;
        }
    }
}
