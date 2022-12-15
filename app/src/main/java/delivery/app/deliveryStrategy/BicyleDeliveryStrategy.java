package delivery.app.deliveryStrategy;

import delivery.app.deliveryPerson.DeliveryPerson;
import delivery.app.order.Order;

public class BicyleDeliveryStrategy extends AbstractDeliveryStrategy{

    public BicyleDeliveryStrategy(Order order, DeliveryPerson deliveryPerson) {
        super(order,deliveryPerson);
    }

    @Override
    public void deliver() {
        System.out.println("Delivery method: Bicycle");
        super.deliver();
    }

    @Override
    public double calculateDeliveryCost() {
        return deliveryDistanceAPI.calculateDeliveryDistance(order.getCustomerAddress())*.25;
    }

    @Override
    public double calculateDeliveryTime() {
        return deliveryDistanceAPI.calculateDeliveryDistance(order.getCustomerAddress()) / 15 * 60;
    }
}