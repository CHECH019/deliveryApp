package delivery.app.delivery;

import delivery.app.order.Order;

public class BicyleDelivery extends AbstractDeliveryService{

    public BicyleDelivery(Order order, DeliveryPerson deliveryPerson) {
        super(order,deliveryPerson);
    }

    @Override
    public void deliver() {
        System.out.println("Bicycle delivery...");
        super.deliver();
    }
    @Override
    public void trackDelivery() {
        
    }

    @Override
    public void cancelDelivery() {
        
    }
}