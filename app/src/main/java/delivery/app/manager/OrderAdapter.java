package delivery.app.manager;

import java.util.List;

import delivery.app.customer.Customer;
import delivery.app.item.Item;
import delivery.app.order.CouponOrderDecorator;
import delivery.app.order.Order;
import delivery.app.order.StandardOrder;

public class OrderAdapter implements OrderManagerAPI{

    private Customer customer;

    public OrderAdapter(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Order makeOrder(List<Item> items,String coupon) {
        Order order = new StandardOrder(10, customer.getName(), customer.getAddress());
        items.forEach(i -> order.addItem(i));
        customer.saveOrderPrototype("my_order1", order);
        
        if(coupon != null && !coupon.isEmpty()){
            Order withCouponOrder = new CouponOrderDecorator(order,coupon);
            customer.addOrder(withCouponOrder);
        }else{
            customer.addOrder(order);
        }
        
        return order;
    }
    
}