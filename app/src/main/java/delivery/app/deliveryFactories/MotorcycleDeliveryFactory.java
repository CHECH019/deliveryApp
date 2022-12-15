package delivery.app.deliveryFactories;

import delivery.app.deliveryPerson.DeliveryPersonManager;
import delivery.app.deliveryStrategy.AbstractDeliveryStrategy;
import delivery.app.deliveryStrategy.MotorcycleDeliveryStrategy;
import delivery.app.order.Order;

public class MotorcycleDeliveryFactory extends DeliveryFactory {

    public MotorcycleDeliveryFactory(Order order) {
        super(order);
        //TODO Auto-generated constructor stub
    }

    @Override
    public AbstractDeliveryStrategy getDeliveryStrategy() {
        return new MotorcycleDeliveryStrategy(order, DeliveryPersonManager.findAvailableDeliveryPerson("MOTORCYCLE"));
    }
    
}
