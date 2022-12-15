package delivery.app.order;

public class HighPriorityOrderDecorator  extends BaseOrderDecorator{

    public static double PRIORITY_ORDER_FEE = 5.5;
    public HighPriorityOrderDecorator(Order order) {
        super(order);
        this.priority = "HIGH";
        this.totalCost = getTotalCost();
    }
    @Override
    public double getTotalCost() {
        return order.getTotalCost()+PRIORITY_ORDER_FEE;
    }
    @Override
    public Order clonar() {
        return new HighPriorityOrderDecorator(this);
    }
    
}
