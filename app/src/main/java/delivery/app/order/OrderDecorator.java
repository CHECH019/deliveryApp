package delivery.app.order;

public abstract class OrderDecorator extends Order {
    

    public OrderDecorator(Order order) {
        super(order);
    }   

    public abstract double getTotalCost() ;
    
}
