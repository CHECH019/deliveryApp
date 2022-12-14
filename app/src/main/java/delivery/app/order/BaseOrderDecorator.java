package delivery.app.order;

public abstract class BaseOrderDecorator extends Order{
    protected Order order;

    public BaseOrderDecorator(Order order){
        super(order);
        this.order = order; 
    }
}
