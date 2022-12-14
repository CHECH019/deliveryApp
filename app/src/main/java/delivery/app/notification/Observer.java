package delivery.app.notification;

import delivery.app.order.Order;

public interface Observer {
    public void update(Order order);
}
