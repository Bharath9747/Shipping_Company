package Shipping_Company;

import java.util.Random;
import java.util.Scanner;

public class MainShippingCompany{
    public static void main(String[] args) throws InterruptedException {
        ShippingCompany shippingCompany = new ShippingCompany();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        shippingCompany.sendToMaintenance();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        t1.start();
        t1.join();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1.Enter the Order");
            System.out.println("2.View All Ship Status");
            System.out.println("Enter the choice");
            int n = sc.nextInt();
            switch (n){
                case 1 : int cargoSize = new Random().nextInt(41)+10;
                        String destination = shippingCompany.getDestination();
                        Order order = new Order(destination,cargoSize);
                        shippingCompany.addOrder(order);
                    break;
                case 2:

                    System.out.println(shippingCompany.shipHashMap);
                    System.out.println(shippingCompany.shipHashMap.size());
                    break;
                    default: System.exit(0);
            }
        }

    }
}