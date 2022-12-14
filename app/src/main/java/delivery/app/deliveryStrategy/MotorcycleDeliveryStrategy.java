package delivery.app.deliveryStrategy;

import delivery.app.deliveryPerson.DeliveryPerson;
import delivery.app.order.Order;

public class MotorcycleDeliveryStrategy extends AbstractDeliveryStrategy {

    public MotorcycleDeliveryStrategy(Order order, DeliveryPerson deliveryPerson) {
        super(order,deliveryPerson);
    }

    @Override
    public void deliver() {
        System.out.println("Motorcycle delivery...");
        super.deliver();
    }


    @Override
    public double calculateDeliveryCost() {
        return deliveryDistanceAPI.calculateDeliveryDistance(order.getCustomerAddress()) * .35;
    }

    @Override
    public double calculateDeliveryTime() {
        return deliveryDistanceAPI.calculateDeliveryDistance(order.getCustomerAddress()) / 40 * 60;
    }

}