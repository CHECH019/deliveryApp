/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package delivery.app;


import java.util.ArrayList;
import java.util.List;

import delivery.app.customer.Customer;
import delivery.app.facade.DeliveryFacade;
import delivery.app.item.Item;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        DeliveryFacade delivery = new DeliveryFacade();

        Customer customer1 = new Customer("Sergio Suarique","Cra 123");

        List<Item> items = new ArrayList<>();
        items.add(new Item("Pizza", 1, 10.99));
        items.add(new Item("Soda", 2, 1.99));

        delivery.createOrder(customer1,items, "D1SC0UNT10","LOW");

    
        Customer customer2 = new Customer("Ximena Perez", "Calle 92");

        
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Burger", 2, 15.99));
        items2.add(new Item("Pepsi", 2, 1.25));

        delivery.createOrder(customer2,items2,"D1SC0UNT20","HIGH");

        delivery.deliver();
        System.out.println("\n---------------------------------------\n");
        delivery.deliver();

    }
}
