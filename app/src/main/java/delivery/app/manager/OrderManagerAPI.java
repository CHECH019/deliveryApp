package delivery.app.manager;

import java.util.List;

import delivery.app.item.Item;
import delivery.app.order.Order;

public interface OrderManagerAPI {
    
    public Order makeOrder(List<Item> items, String coupon);
    
}
