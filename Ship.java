package Shipping_Company;

import java.util.ArrayList;
import java.util.List;

class Ship{
    int trips=0;

    public int getTrips() {
        return trips;
    }
    public void setTrips() {
        trips=0;
    }

    public static void addTrips(Ship s) {
        s.trips++;
    }

    private String source;

    public void setSource(String source) {
        this.source = source;
    }
    public String getSource() {
        return source;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    private String msg;
    public List<Order> orderList = new ArrayList<>();

    private int cargoSize;

    public int getCargoSize() {
        return cargoSize;
    }

    @Override
    public String toString() {
        return  "trips=" + trips +
                ", source='" + source + '\'' +
                ", orderList=" + orderList +
                ", cargoSize=" + cargoSize ;
    }

    public void setCargoSize(int cargoSize) {
        this.cargoSize = cargoSize;
    }

    public void addCargoSize(int cargoSize) {
        this.cargoSize += cargoSize;
    }

    public Ship(String source) {
        this.source = source;
        this.msg = "Adding Cargo in "+source;
    }
}