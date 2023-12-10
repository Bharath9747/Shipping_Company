package Shipping_Company;

import java.util.ArrayList;
import java.util.HashMap;


class ShippingCompany{
    ArrayList<Ship> ships;
    HashMap<Integer,Ship> shipHashMap = new HashMap<>();
    int trip=0;
    ShippingCompany()
    {
        ships = new ArrayList<>(5);
        ships.add(new Ship("Gotham"));
    }

    @Override
    public String toString() {
        return  "ships=" + ships +
                ", shipHashMap=" + shipHashMap;
    }

    public void addOrder(Order order) {
        ships.get(0).orderList.add(order);
        ships.get(0).addCargoSize(order.getCargoWeight());
        if(ships.get(0).getCargoSize()>=50)
        {
            Ship ship = ships.get(0);
            shipHashMap.put(++trip,ship);
            String source = ships.get(0).getSource().equals("Gotham")?"Atlanta":"Gotham";
            ships.set(0,new Ship(source));

        }

    }

    public String getDestination() {
        return ships.get(0).getSource().equals("Gotham")?"Atlanta":"Gotham";
    }
    public void  sendToMaintenance() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while ((shipHashMap.size()!=0)&& shipHashMap.size() % 5 == 0) {
                    try {
                        System.out.println("Ship is going to Maintenance");
                        Thread.sleep(60000);
                        String source = ships.get(0).getSource().equals("Gotham") ? "Atlanta" : "Gotham";
                        ships.set(0, new Ship(source));
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                

            }
        }
    }

}