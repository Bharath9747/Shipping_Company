package Shipping_Company;

import java.util.ArrayList;
import java.util.List;

class Ship{
    private boolean isAvailable = true;
    private int Id;

    public int getId() {
        return Id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    private String source;

    public String getSource() {
        return source;
    }


    public List<Order> orderList = new ArrayList<>();

    private int cargoSize;

    public int getCargoSize() {
        return cargoSize;
    }

    @Override
    public String toString() {
        return  ", source='" + source + '\'' +
                ", orderList=" + orderList +
                ", cargoSize=" + cargoSize ;
    }


    public void addCargoSize(int cargoSize) {
        this.cargoSize += cargoSize;
    }

    public Ship(int Id,String source) {
        this.Id =Id;this.source = source;
    }
}