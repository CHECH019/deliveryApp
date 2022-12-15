package delivery.app.manager;

import java.util.LinkedList;
import java.util.Queue;

import delivery.app.deliveryFactories.BicycleDeliveryFactory;
import delivery.app.deliveryFactories.DeliveryDistanceFactory;
import delivery.app.deliveryFactories.DeliveryFactory;
import delivery.app.deliveryFactories.MotorcycleDeliveryFactory;
import delivery.app.deliveryStrategy.AbstractDeliveryStrategy;
import delivery.app.order.Order;

public class DeliveryManager {

    private Queue<Order> highPriorityOrders;
    private Queue<Order> orders;
    private Queue<Order> lowPriorityOrders;
    private AbstractDeliveryStrategy deliveryStrategy;
    private DeliveryFactory factory;
  
    public DeliveryManager() {
        this.orders = new LinkedList<>();
        this.highPriorityOrders = new LinkedList<>();
        this.lowPriorityOrders = new LinkedList<>();
    }


    public void deliver(){
        Order o = null;
        if(!highPriorityOrders.isEmpty()){
            o = highPriorityOrders.poll();
            factory = new MotorcycleDeliveryFactory(o);
        }else if(!orders.isEmpty()){
            o = orders.poll();
            factory = new DeliveryDistanceFactory(o);
        }else if(!lowPriorityOrders.isEmpty()){
            o = lowPriorityOrders.poll();
            factory = new BicycleDeliveryFactory(o);
        }
        if(o != null){
            deliver(o);
            o.printOrder();
        }else{
            System.out.println("ERROR: Couldn't deliver Order");
        }
        
    }

    public void deliver(Order order){
        deliveryStrategy = factory.getDeliveryStrategy();
        System.out.println("Delivery ETA: "+deliveryStrategy.calculateDeliveryTime()+" minutes");
        System.out.println("Delivery fee: $"+getDeliveryCost());
        
        deliveryStrategy.deliver();
    }

    public double getDeliveryTime(){
        return deliveryStrategy.calculateDeliveryTime();
    }

    public double getDeliveryCost(){
        return deliveryStrategy.calculateDeliveryCost();
    }

    public void trackDelivery(){

    }

    public void cancelDelivery(Order order){
        
        if ("IN_PROGRESS".equals(order.getDeliveryStatus())) {
            // Set the delivery status to "CANCELLED" and release the delivery person
            order.setDeliveryStatus("CANCELLED");
            deliveryStrategy.getDeliveryPerson().setAvailable(true);
        } else {
            System.out.println("Unable to cancel delivery: order is not in progress.");
        }
    }
    public void addOrder(Order order){
        if(order.getPriority().equalsIgnoreCase("HIGH")){
            highPriorityOrders.add(order);
            
        }else if(order.getPriority().equalsIgnoreCase("LOW")){
            lowPriorityOrders.add(order);
            
        }else {
            orders.add(order);
        }
    }
}