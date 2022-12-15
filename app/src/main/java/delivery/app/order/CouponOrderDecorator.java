package delivery.app.order;



public class CouponOrderDecorator extends BaseOrderDecorator{

    private String coupon;
    

    public CouponOrderDecorator(Order order, String coupon) {
        super(order);
        this.coupon = coupon;
        totalCost = getTotalCost();
    }

    @Override
    public double getTotalCost() {
        if(variables.existCoupon(coupon)){
            double discountAmount = order.totalCost * variables.getCouponDiscount(coupon) / 100;
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
