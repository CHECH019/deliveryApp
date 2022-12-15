package delivery.app.deliveryFactories;

import delivery.app.deliveryPerson.DeliveryPersonManager;
import delivery.app.deliveryStrategy.AbstractDeliveryStrategy;
import delivery.app.deliveryStrategy.BicyleDeliveryStrategy;
import delivery.app.order.Order;

public class BicycleDeliveryFactory extends DeliveryFactory {

    public BicycleDeliveryFactory(Order order) {
        super(order);
    }

    @Override
    public AbstractDeliveryStrategy getDeliveryStrategy() {
        return new BicyleDeliveryStrategy(order, DeliveryPersonManager.findAvailableDeliveryPerson("BICYCLE"));
    }
    
}
