package delivery.app.delivery;

import delivery.app.deliveryPerson.DeliveryPerson;
import delivery.app.order.Order;

public abstract class AbstractDeliveryStrategy implements DeliveryServiceStrategy{

    protected Order order;
    protected DeliveryPerson deliveryPerson;

    public AbstractDeliveryStrategy(Order order, DeliveryPerson deliveryPerson){
        this.order = order;
        this.deliveryPerson = deliveryPerson;
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