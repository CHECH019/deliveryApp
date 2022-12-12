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
  
    
    public void trackDelivery(Order order) {
        
    }

    
    public void cancelDelivery(Order order) {
        
    }
}