package delivery.app.order;

public class HighPriorityOrderDecorator  extends BaseOrderDecorator{

    public HighPriorityOrderDecorator(Order order) {
        super(order);
        this.priority = "HIGH";
        this.totalCost = getTotalCost();
    }
    @Override
    public double getTotalCost() {
        return order.getTotalCost()+variables.getPriorityOrderFee();
    }
    @Override
    public Order clonar() {
        return new HighPriorityOrderDecorator(this);
    }
    
}
