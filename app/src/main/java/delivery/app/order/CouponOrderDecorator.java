package delivery.app.order;

import delivery.app.utils.BonusCodes;

public class CouponOrderDecorator extends BaseOrderDecorator{

    private String coupon;

    public CouponOrderDecorator(Order order, String coupon) {
        super(order);
        this.coupon = coupon;
        totalCost = getTotalCost();
    }

    @Override
    public double getTotalCost() {
        if(BonusCodes.get().containsKey(coupon)){
            double discountAmount = order.totalCost * BonusCodes.get().get(coupon) / 100;
            return order.totalCost - discountAmount;
        } else {
            return order.totalCost;
        }
    }

    @Override
    public Order clonar() {
        return new CouponOrderDecorator(this, coupon);
    }
    
}
