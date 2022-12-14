package delivery.app.deliveryFactories;

import delivery.app.deliveryStrategy.AbstractDeliveryStrategy;
import delivery.app.distanceDeliveryService.DeliveryDistanceAPI;
import delivery.app.distanceDeliveryService.DeliveryDistanceAdapter;
import delivery.app.distanceDeliveryService.DeliveryDistanceCalculator;
import delivery.app.order.Order;

public abstract class DeliveryFactory {
    protected Order order;
    protected DeliveryDistanceAPI deliveryDistanceAPI;

    
    public DeliveryFactory(Order order) {
        this.order = order;
        this.deliveryDistanceAPI = new DeliveryDistanceAdapter(new DeliveryDistanceCalculator());
    }


    public abstract AbstractDeliveryStrategy  getDeliveryStrategy();
}
