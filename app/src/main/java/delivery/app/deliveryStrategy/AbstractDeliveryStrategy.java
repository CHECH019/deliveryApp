package delivery.app.deliveryStrategy;

import delivery.app.deliveryPerson.DeliveryPerson;
import delivery.app.distanceDeliveryService.DeliveryDistanceAPI;
import delivery.app.distanceDeliveryService.DeliveryDistanceAdapter;
import delivery.app.distanceDeliveryService.DeliveryDistanceCalculator;
import delivery.app.order.Order;

public abstract class AbstractDeliveryStrategy implements DeliveryServiceStrategy{

    protected Order order;
    protected DeliveryPerson deliveryPerson;
    protected DeliveryDistanceAPI deliveryDistanceAPI;

    public AbstractDeliveryStrategy(Order order, DeliveryPerson deliveryPerson){
        this.order = order;
        this.deliveryPerson = deliveryPerson;
        this.deliveryDistanceAPI = new DeliveryDistanceAdapter(new DeliveryDistanceCalculator());
    }

    public void deliver() {
        if (deliveryPerson != null) {
            deliveryPerson.setOrder(order);
            order.setDeliveryStatus("IN_PROGRESS");
        } else {
            order.setDeliveryStatus("DELIVERY_FAILED");
        }
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }   
}