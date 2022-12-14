package delivery.app.delivery;

import delivery.app.deliveryPerson.DeliveryPerson;
import delivery.app.order.Order;

public class BicyleDeliveryStrategy extends AbstractDeliveryStrategy{

    public BicyleDeliveryStrategy(Order order, DeliveryPerson deliveryPerson) {
        super(order,deliveryPerson);
    }

    @Override
    public void deliver() {
        System.out.println("Bicycle delivery...");
        super.deliver();
    }

    @Override
    public double calculateDeliveryCost() {
        return order.getDistance()*.25;
    }

    @Override
    public double calculateDeliveryTime() {
        return  order.getDistance() / 15 * 60;
    }
}