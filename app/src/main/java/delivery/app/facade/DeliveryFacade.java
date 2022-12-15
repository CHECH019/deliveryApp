package delivery.app.facade;

import java.util.List;

import delivery.app.customer.Customer;
import delivery.app.item.Item;
import delivery.app.manager.DeliveryManager;
import delivery.app.notification.NotificationListener;
import delivery.app.order.CouponOrderDecorator;
import delivery.app.order.Order;
import delivery.app.order.HighPriorityOrderDecorator;
import delivery.app.order.LowPriorityOrderDecorator;
import delivery.app.order.StandardOrder;

public class DeliveryFacade {
    
    private DeliveryManager manager;
    


    public DeliveryFacade(){
        manager = new DeliveryManager();
    }

    public void createOrder(Customer customer,List<Item> items){
        createOrder(customer, items, null, null);
    }
    public void createOrder(Customer customer,List<Item> items, String coupon,String priority){
        Order order;
        Order simpleOrder = new StandardOrder(customer.getName(), customer.getAddress());
        items.forEach(i -> simpleOrder.addItem(i));
        customer.saveOrderPrototype("my_order1", simpleOrder);

        order = simpleOrder;
        
        if(coupon != null && !coupon.isEmpty()){
            order = new CouponOrderDecorator(simpleOrder,coupon);
        }
        if(priority.equalsIgnoreCase("HIGH")){
            order = new HighPriorityOrderDecorator(order);
        }else if(priority.equalsIgnoreCase("LOW")){
            order = new LowPriorityOrderDecorator(order);
        }
        customer.addOrder(order);
        order.nofitier.subscribe(new NotificationListener());
        manager.addOrder(order);
    }

    public void deliver(){
        manager.deliver();
    }
    public void cancel(){
        // manager.cancelDelivery();
    }
    
}