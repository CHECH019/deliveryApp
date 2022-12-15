package delivery.app.order;

public class LowPriorityOrderDecorator extends BaseOrderDecorator {


    public LowPriorityOrderDecorator(Order order) {
        super(order);
        this.totalCost = getTotalCost();
        this.priority = "LOW";
    }

    
    @Override
    public double getTotalCost() {
        return order.getTotalCost()-order.getTotalCost()*variables.getLowPriotityDiscount();
    }
    @Override
    public Order clonar() {
        // TODO Auto-generated method stub
        return new LowPriorityOrderDecorator(this);
    }

}
