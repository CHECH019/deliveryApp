package delivery.app.order;


public class StandardOrder extends Order{
    
    private StandardOrder(Order order) {
        super(order);
    }

    public StandardOrder(int distance, String customerName, String customerAddress) {
        super(distance, customerName, customerAddress);
    }

    @Override
    public Order clonar() {
        return new StandardOrder(this);
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

}