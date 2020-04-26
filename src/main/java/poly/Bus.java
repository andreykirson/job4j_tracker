package poly;

public class Bus implements Transport {

    public int gasTank, passenger;

    @Override
    public void drive() {
        boolean drive = true;
    }

    @Override
    public void passengers(int count) {
        this.passenger = count;
    }

    @Override
    public int refuel(int fuel) {
        this.gasTank = this.gasTank + fuel;
        int cost = fuel * 5;
        return cost;
    }
}
