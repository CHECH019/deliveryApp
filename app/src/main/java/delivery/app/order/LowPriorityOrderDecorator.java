package delivery.app.order;

public class LowPriorityOrderDecorator extends BaseOrderDecorator {

    private static double LOW_PRIORITY_DISCOUNT = 0.02;
    public LowPriorityOrderDecorator(Order order) {
        super(order);
        this.totalCost = getTotalCost();
        this.priority = "LOW";
    }

    
    @Override
    public double getTotalCost() {
        return order.getTotalCost()-order.getTotalCost()*LOW_PRIORITY_DISCOUNT;
    }
    @Override
    public Order clonar() {
        // TODO Auto-generated method stub
        return new LowPriorityOrderDecorator(this);
    }

}
