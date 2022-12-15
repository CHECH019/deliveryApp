package delivery.app.deliveryStrategy;

import delivery.app.deliveryPerson.DeliveryPerson;
import delivery.app.distanceDeliveryService.DeliveryDistanceAPI;
import delivery.app.distanceDeliveryService.DeliveryDistanceAdapter;
import delivery.app.distanceDeliveryService.DeliveryDistanceCalculator;
import delivery.app.order.Order;

public abstract class AbstractDeliveryStrategy implements DeliveryServiceStrategy{

    protected Order order;
    public Order getOrder() {
        return order;
    }

    protected DeliveryPerson deliveryPerson;
    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

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
            order.setDeliveryTime(calculateDeliveryTime());
            order.setDeliveryFee(calculateDeliveryCost());
        } else {
            order.setDeliveryStatus("DELIVERY_FAILED");
        }
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }   
}