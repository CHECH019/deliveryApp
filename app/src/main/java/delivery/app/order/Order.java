package delivery.app.order;

import java.util.ArrayList;
import java.util.List;

import delivery.app.item.Item;
import delivery.app.notification.OrderNotifier;
import delivery.app.utils.Prototype;

public abstract class Order implements Prototype {
    
    protected String deliveryStatus;
    protected String customerName;
    protected String customerAddress;
    protected List<Item> items;
    protected double totalCost;
    protected double deliveryFee;
    protected String priority;

    

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    protected double deliveryTime;
    public double getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(double deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public OrderNotifier nofitier;

    public Order(){}

    public Order(Order order){
        this.customerName = order.customerName;
        this.customerAddress = order.customerAddress;
        this.totalCost = order.totalCost;
        this.priority = order.priority;
        this.items = new ArrayList<>(order.getItems());
        this.nofitier = new OrderNotifier();
    }
    
    public Order(String customerName, String customerAddress) {
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
        System.out.println("- Items: ");
        for (Item item : items) {
          System.out.println("  - " + item.getName() + " (" + item.getQuantity() + " x $" + item.getPrice() + ")");
        }
        System.out.println("- Total cost: $" + getTotalCost());
    }
    
}
