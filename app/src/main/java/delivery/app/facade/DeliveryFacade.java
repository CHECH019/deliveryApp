package delivery.app.facade;

import java.util.List;

import delivery.app.customer.Customer;
import delivery.app.deliveryServices.DeliveryDistanceFactory;
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
    private DeliveryFactory deliveryFactory;
    private Order order;

    public DeliveryFacade(){}

    public DeliveryFacade(Customer customer){
        this.customer = customer;
    }

    public DeliveryFactory getDeliveryFactory() {
        return deliveryFactory;
    }

    public void setDeliveryFactory(DeliveryFactory deliveryFactory) {
        this.deliveryFactory = deliveryFactory;
    }



    public void createOrder(List<Item> items){
        createOrder(items,null);
    }
    public void createOrder(List<Item> items, String coupon){
        Order simpleOrder = new StandardOrder(customer.getName(), customer.getAddress());
        items.forEach(i -> simpleOrder.addItem(i));
        customer.saveOrderPrototype("my_order1", simpleOrder);

        order = simpleOrder;
        
        if(coupon != null && !coupon.isEmpty()){
            order = new CouponOrderDecorator(simpleOrder,coupon);
        }
        customer.addOrder(order);
        order.nofitier.subscribe(new NotificationListener());
        order.printOrder();
        setDeliveryFactory(new DeliveryDistanceFactory(order));
    }

    public void deliver(){
        manager = new DeliveryManager(deliveryFactory.getDeliveryStrategy());
        manager.deliver();
        
    }
    
}