package delivery.app.delivery;

import delivery.app.manager.DeliveryPersonManager;
import delivery.app.order.Order;

public class DeliveryFactory {
    public static DeliveryService  createDeliveryMethod(Order o){
        return o.getDistance() < 5 ? new BicyleDelivery(o,DeliveryPersonManager.findAvailableDeliveryPerson("BICYCLE")) : new MotorcycleDelivery(o,DeliveryPersonManager.findAvailableDeliveryPerson("MOTORCYCLE"));
    }
}
