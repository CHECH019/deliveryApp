package delivery.app.notification;

import delivery.app.order.Order;

public class NotificationListener implements Observer {

    @Override
    public void update(Order order) {
        System.out.println("The "+order.getCustomerName()+"'s order status is:  "+order.getDeliveryStatus());
        
    }
    
}
