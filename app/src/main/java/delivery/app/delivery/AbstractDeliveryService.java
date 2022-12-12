package delivery.app.delivery;

import delivery.app.order.Order;

public abstract class AbstractDeliveryService implements DeliveryService{

    protected Order order;
    protected DeliveryPerson deliveryPerson;

    public AbstractDeliveryService(Order order, DeliveryPerson deliveryPerson){
        this.order = order;
        this.deliveryPerson = deliveryPerson;
    }

    public void deliver() {
        if (deliveryPerson != null) {
            deliveryPerson.setOrder(order);
            order.setDeliveryStatus("IN_PROGRESS");
        } else {
            // If no delivery person is found, set the delivery status to "DELIVERY_FAILED".
            order.setDeliveryStatus("DELIVERY_FAILED");
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }   
}