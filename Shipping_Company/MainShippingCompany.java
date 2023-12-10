package Shipping_Company;

import java.util.Random;
import java.util.Scanner;

public class MainShippingCompany{

    static Object lock = new Object();
    static int trips=0;

    public static void main(String[] args) throws InterruptedException {
        ShippingCompany shippingCompany = new ShippingCompany();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        shippingCompany.sendOrders();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
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
        t2.start();
        t1.join();
        t2.join();


    }


}