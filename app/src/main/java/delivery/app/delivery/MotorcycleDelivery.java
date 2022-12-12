package delivery.app.delivery;

import delivery.app.order.Order;

public class MotorcycleDelivery extends AbstractDeliveryService {

    public MotorcycleDelivery(Order order, DeliveryPerson deliveryPerson) {
        super(order,deliveryPerson);
    }

    @Override
    public void deliver() {
        System.out.println("Motorcycle delivery...");
        super.deliver();
    }

    @Override
    public void trackDelivery() {
        
    }

    @Override
    public void cancelDelivery() {
        
    }

}