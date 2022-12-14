package delivery.app.order;

import java.util.ArrayList;
import java.util.List;

import delivery.app.item.Item;
import delivery.app.notification.OrderNotifier;
import delivery.app.utils.Prototype;

public abstract class Order implements Prototype {
    
    protected String deliveryStatus;
    protected double distance;
    protected String customerName;
    protected String customerAddress;
    protected List<Item> items;
    protected double totalCost;
    public OrderNotifier nofitier;

    public Order(){}

    public Order(Order order){
        this.distance = order.distance;
        this.customerName = order.customerName;
        this.customerAddress = order.customerAddress;
        this.totalCost = order.totalCost;
        this.items = new ArrayList<>(order.getItems());
        this.nofitier = new OrderNotifier();
    }
    
    public Order(int distance, String customerName, String customerAddress) {
        this.distance = distance;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.totalCost = 0;
        items = new ArrayList<>();
        this.nofitier = new OrderNotifier();
    }
    
    public abstract double getTotalCost() ;

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        doNotify();
    }

    public void doNotify(){
        nofitier.notifyObservers(this);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    public void addItem(Item item){
        items.add(item);
        totalCost += item.getPrice()*item.getQuantity();
    }

    public void printOrder(){
        System.out.println("Order details:");
        System.out.println("- Customer name: " + customerName);
        System.out.println("- Customer address: " + customerAddress);
        System.out.println("- Distance: " + distance + " km");
        System.out.println("- Items: ");
        for (Item item : items) {
          System.out.println("  - " + item.getName() + " (" + item.getQuantity() + " x $" + item.getPrice() + ")");
        }
        System.out.println("- Total cost: $" + getTotalCost());
    }
    
}
