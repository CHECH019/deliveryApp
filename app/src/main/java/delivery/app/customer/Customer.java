package delivery.app.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import delivery.app.order.Order;

public class Customer {
    Map<String, Order> myCustomOrders = new HashMap<>();
    private List<Order> orders;
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printOrders() {
        System.out.println("Customer: " + name);
        System.out.println("Address: " + address);
        System.out.println("Orders: ");
        for (Order order : orders) {
            order.printOrder();
        }
    }

    public void saveOrderPrototype(String name, Order prototype) {
        myCustomOrders.put(name, prototype);
    }

    public Order getOrderPrototype(String name) {
        Order prototype = myCustomOrders.get(name);
        if (prototype != null) {
            return prototype.clonar();
        } else {
            return null;
        }
    }

}