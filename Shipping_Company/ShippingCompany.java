package Shipping_Company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


class ShippingCompany{
    ArrayList<Ship> ships;
    int[] tripCountShip = new int[5];
    Integer t=0;

    int trips=1;
    ShippingCompany()
    {
        ships = new ArrayList<>(5);
        ships.add(new Ship(1,"Gotham"));
        ships.add(new Ship(2,"Atlanta"));
        ships.add(new Ship(3,"Gotham"));
        ships.add(new Ship(4,"Atlanta"));
        ships.add(new Ship(5,"Gotham"));
    }


    public void addOrder(Order order) {
        String orderDestination = order.getDestination();
        List<Ship> shipList = new ArrayList<>();
        for (Ship ship : ships) {
            if ((!ship.getSource().equals(orderDestination)) && ship.isAvailable())
                shipList.add(ship);
        }
        if (shipList.size() == 0)
            return;
        else {
            Ship temp = shipList.get(0);
            temp.orderList.add(order);
            temp.addCargoSize(order.getCargoWeight());
            if (temp.getCargoSize() >= 50) {
                temp.setAvailable(false);
                String source = temp.getSource().equals("Gotham") ? "Atlanta" : "Gotham";
                tripCountShip[temp.getId()-1]++;
                ships.set(0, new Ship(temp.getId(), source));
                t++;
                try {
                    FileWriter fWriter = new FileWriter("result.txt", true);
                    fWriter.write("Trip : " + trips++);
                    fWriter.write("\n");
                    fWriter.write("Ship : " + temp.getId());

                    fWriter.write("\n");
                    fWriter.write("Source : " + temp.getSource());
                    fWriter.write("\n");
                    fWriter.write("Destination : " + temp.orderList.get(0).getDestination());
                    fWriter.write("\n");
                    fWriter.write("Orders");
                    fWriter.write("\n");
                    for (Order order1 : temp.orderList) {

                        fWriter.write(String.valueOf(order1));
                        fWriter.write("\n");

                    }
                    fWriter.write("Total Cargo Size : " + temp.getCargoSize());
                    fWriter.write("\n");
                    fWriter.write("\n");

                    fWriter.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }
    }


    public void  sendToMaintenance() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (t==0)
                    wait();
                notify();
                Thread.sleep(1000);
           }
        }
    }
    public void sendOrders() throws InterruptedException {
        while (true){
            synchronized (this) {
                for(int i=0;i<5;i++) {
                    while (tripCountShip[i]%5 == 0) {
                        System.out.println();
                        System.out.println("Ship "+(i+1)+" is going to Maintenance");
                        System.out.println();
                        System.out.println(Arrays.toString(tripCountShip));
                        wait();
                    }
                }
                int cargoSize = new Random().nextInt(41) + 10;
                String destination = new Random().nextBoolean()?"Gotham":"Atlanta";
                Order order = new Order(destination, cargoSize);
                addOrder(order);

                notify();

            }
        }
    }

}