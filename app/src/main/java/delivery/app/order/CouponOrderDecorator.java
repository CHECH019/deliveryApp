package delivery.app.order;

import java.util.Map;

import delivery.app.utils.BonusCodes;

public class CouponOrderDecorator extends OrderDecorator{

    public String coupon;
    Map<String,Double> existingCodes;

    public CouponOrderDecorator(Order order, String coupon) {
        super(order);
        this.coupon = coupon;
        existingCodes = BonusCodes.getCodes();
    }

    @Override
    public double getTotalCost() {
        if(existingCodes.containsKey(coupon)){
            double discountAmount = totalCost * existingCodes.get(coupon) / 100;
            return totalCost - discountAmount;
        } else {
            return totalCost;
        }
    }

    @Override
    public Order clonar() {
        return new CouponOrderDecorator(this, coupon);
    }
    
}
