/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package delivery.app;


import java.util.ArrayList;
import java.util.List;

import delivery.app.customer.Customer;
import delivery.app.facade.DeliveryFacade;
import delivery.app.item.Item;
import delivery.app.manager.OrderAdapter;
import delivery.app.manager.OrderManagerAPI;
import delivery.app.order.Order;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
       // Create a customer.
        Customer customer = new Customer("John Doe", "123 Main St");

        // Create a list of items to be added to the order.
        List<Item> items = new ArrayList<>();
        items.add(new Item("Pizza", 1, 10.99));
        items.add(new Item("Soda", 2, 1.99));

        OrderManagerAPI orderManager = new OrderAdapter(customer);

        Order order = orderManager.makeOrder(items,"D1SC0UNT10");

        DeliveryFacade facade = new DeliveryFacade();

        facade.deliver(order);
        
        facade.trackDelivery(order);

        facade.cancelDelivery(order);

        customer.getOrders().get(0).printOrder();
        
    }
}