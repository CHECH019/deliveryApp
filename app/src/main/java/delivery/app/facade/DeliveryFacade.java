package delivery.app.facade;

import delivery.app.manager.DeliveryManager;
import delivery.app.order.Order;

public class DeliveryFacade {
    private DeliveryManager deliveryManager;

    public DeliveryFacade() {
        this.deliveryManager = DeliveryManager.getInstance();
    }

    public void deliver(Order order) {
        deliveryManager.deliver(order);
    }

    public void trackDelivery(Order order) {
        deliveryManager.trackDelivery(order);
    }

    public void cancelDelivery(Order order) {
        deliveryManager.cancelDelivery(order);
    }
}