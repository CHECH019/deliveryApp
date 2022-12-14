package delivery.app.deliveryServices;

import delivery.app.deliveryPerson.DeliveryPersonManager;
import delivery.app.deliveryStrategy.BicyleDeliveryStrategy;
import delivery.app.deliveryStrategy.DeliveryServiceStrategy;
import delivery.app.deliveryStrategy.MotorcycleDeliveryStrategy;
import delivery.app.order.Order;

public class DeliveryDistanceFactory extends DeliveryFactory {

    public DeliveryDistanceFactory(Order order) {
        super(order);
    }

    @Override
    public DeliveryServiceStrategy getDeliveryStrategy() {
        return deliveryDistanceAPI.calculateDeliveryDistance(order.getCustomerAddress()) < 10 ? new BicyleDeliveryStrategy(order,DeliveryPersonManager.findAvailableDeliveryPerson("BICYCLE")) : new MotorcycleDeliveryStrategy(order,DeliveryPersonManager.findAvailableDeliveryPerson("MOTORCYCLE"));
        
    }
    
}
