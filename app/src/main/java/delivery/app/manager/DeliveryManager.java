package delivery.app.manager;

import delivery.app.delivery.DeliveryFactory;
import delivery.app.delivery.DeliveryService;
import delivery.app.order.Order;

public class DeliveryManager {
    private static DeliveryManager instance;
  
    private DeliveryManager() {}
  
    public static DeliveryManager getInstance() {
        if (instance == null) {
            instance = new DeliveryManager();
        }
        return instance;
    }

    public void deliver(Order order){
        DeliveryService deliveryService = DeliveryFactory.createDeliveryMethod(order);
        deliveryService.deliver();
    }
  
    // Method to track the delivery status of an order.
    public void trackDelivery(Order order) {
        // Implement the logic to track the delivery status of the order.
    }

    // Method to cancel a delivery.
    public void cancelDelivery(Order order) {
        // Implement the logic to cancel the delivery of the order.
    }
}