package Shipping_Company;

class Order{
    private String destination ;

    public Order(String destination, int cargoWeight) {
        this.destination = destination;
        this.cargoWeight = cargoWeight;
    }

    public String getDestination() {
        return destination;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    private int cargoWeight;

    @Override
    public String toString() {
        return  "destination='" + destination + '\'' +
                ", cargoWeight=" + cargoWeight ;
    }
}
