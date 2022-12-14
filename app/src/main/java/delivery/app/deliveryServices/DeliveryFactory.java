package delivery.app.deliveryServices;

import delivery.app.delivery.BicyleDeliveryStrategy;
import delivery.app.delivery.DeliveryServiceStrategy;
import delivery.app.delivery.MotorcycleDeliveryStrategy;
import delivery.app.deliveryPerson.DeliveryPersonManager;
import delivery.app.order.Order;

public class DeliveryFactory {
    public static DeliveryServiceStrategy  getDeliveryStrategy(Order o){
        return o.getDistance() < 10 ? new BicyleDeliveryStrategy(o,DeliveryPersonManager.findAvailableDeliveryPerson("BICYCLE")) : new MotorcycleDeliveryStrategy(o,DeliveryPersonManager.findAvailableDeliveryPerson("MOTORCYCLE"));
    }
}
