public class Road {
    private City city1;
    private City city2;
    private int distance;
    private TransportMode mode;
    private int trafficMultiplier; // Traffic impact multiplier

    public Road(City city1, City city2, int distance, TransportMode mode, int trafficMultiplier) {
        this.city1 = city1;
        this.city2 = city2;
        this.distance = distance;
        this.mode = mode;
        this.trafficMultiplier = trafficMultiplier;
    }

    public City getCity1() {
        return city1;
    }

    public City getCity2() {
        return city2;
    }

    public int getDistance() {
        return distance;
    }

    public TransportMode getMode() {
        return mode;
    }

    public int getTrafficMultiplier() {
        return trafficMultiplier;
    }

    public int getTravelTime() {
        return (distance / mode.getSpeed()) * trafficMultiplier;
    }

    public int getTravelCost() {
        return distance * mode.getCostPerKm();
    }
}
