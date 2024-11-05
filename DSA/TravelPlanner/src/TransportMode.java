public enum TransportMode {
    CAR(60, 5),       // Speed in km/h, Cost per km
    BUS(50, 3),
    TRAIN(80, 2),
    FLIGHT(500, 10);

    private int speed;      // Speed in km/h
    private int costPerKm;  // Cost per km

    TransportMode(int speed, int costPerKm) {
        this.speed = speed;
        this.costPerKm = costPerKm;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCostPerKm() {
        return costPerKm;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
