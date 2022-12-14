package delivery.app.facade;

import java.util.List;

import delivery.app.customer.Customer;
import delivery.app.deliveryServices.DeliveryFactory;
import delivery.app.deliveryServices.DeliveryManager;
import delivery.app.item.Item;
import delivery.app.notification.NotificationListener;
import delivery.app.order.CouponOrderDecorator;
import delivery.app.order.Order;
import delivery.app.order.StandardOrder;

public class DeliveryFacade {
    
    private Customer customer;
    private DeliveryManager manager;
    private Order order;

    public DeliveryFacade(){}

    public DeliveryFacade(Customer customer){
        this.customer = customer;
    }

    public void createOrder(List<Item> items){
        createOrder(items,null);
    }
    public void createOrder(List<Item> items, String coupon){
        Order simpleOrder = new StandardOrder(getDeliveryDistance(customer.getAddress()), customer.getName(), customer.getAddress());
        items.forEach(i -> simpleOrder.addItem(i));
        customer.saveOrderPrototype("my_order1", simpleOrder);

        order = simpleOrder;
        
        if(coupon != null && !coupon.isEmpty()){
            order = new CouponOrderDecorator(simpleOrder,coupon);
        }
        customer.addOrder(order);
        simpleOrder.nofitier.subscribe(new NotificationListener());
        order.printOrder();
    }

    public void deliver(){
        manager = new DeliveryManager(DeliveryFactory.getDeliveryStrategy(order));
        manager.deliver();
        
    }
    public int getDeliveryDistance(String address){
        Integer distance;
        String d = address.split(" ")[1];
        distance = 100 - Integer.parseInt(d);
        return distance > 0 ? distance:-distance;

    }

}